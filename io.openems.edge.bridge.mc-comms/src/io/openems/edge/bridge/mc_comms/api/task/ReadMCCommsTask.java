package io.openems.edge.bridge.mc_comms.api.task;

import io.openems.edge.bridge.mc_comms.MCCommsBridge;
import io.openems.edge.bridge.mc_comms.api.element.MCCommsElement;
import io.openems.edge.bridge.mc_comms.util.AbstractMCCommsComponent;
import io.openems.edge.bridge.mc_comms.util.MCCommsException;
import io.openems.edge.bridge.mc_comms.util.MCCommsPacket;
import io.openems.edge.bridge.mc_comms.util.MCCommsProtocol;
import io.openems.edge.common.taskmanager.ManagedTask;
import io.openems.edge.common.taskmanager.Priority;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ReadMCCommsTask extends AbstractMCCommsTask implements ManagedTask {

    private final int expectedReplyCommand;
    private final int readReplyTimeout;

    public ReadMCCommsTask(int readCommand, int expectedReplyCommand, Priority priority, MCCommsElement<?>... elements) {
        super(readCommand, priority, elements);
        this.expectedReplyCommand = expectedReplyCommand;
        readReplyTimeout = 100;
    }

    public ReadMCCommsTask(int readCommand, int expectedReplyCommand, Priority priority, int readReplyTimeout, MCCommsElement<?>... elements) {
        super(readCommand, priority, elements);
        this.expectedReplyCommand = expectedReplyCommand;
        this.readReplyTimeout = readReplyTimeout;
    }


    /**
     * Sends a query for this AbstractMCCommsTask to the MCComms device
     *
     * @throws MCCommsException
     */
    @Override
    public void executeQuery() throws MCCommsException {
        MCCommsProtocol protocol = this.getProtocol();
        AbstractMCCommsComponent parentComponent = protocol.getParentComponentAtomicRef().get();
        MCCommsBridge bridge = parentComponent.getMCCommsBridgeAtomicRef().get();
        int slaveAddress = parentComponent.getSlaveAddress();
        bridge.getIOPacketBuffer().getTXPacketQueue().add(new MCCommsPacket(this.command, bridge.getMasterAddress(), slaveAddress));
        MCCommsPacket commandReplyPacket = parentComponent.getPacket(expectedReplyCommand, readReplyTimeout);
        if (commandReplyPacket != null) {
            //retrieve payload
            int[] payload = commandReplyPacket.getPayload();
            //assign payload bytes to elements
            for (MCCommsElement<?> element : this.elements) {
                int byteAddress, numBytes;
                byteAddress = element.getByteAddress();
                numBytes = element.getNumBytes();
                ByteBuffer elementBuffer = ByteBuffer.allocate(numBytes);
                for (int i = byteAddress; i <= (byteAddress + numBytes); i++) {
                    elementBuffer.order(ByteOrder.BIG_ENDIAN).put((byte) payload[i]);
                }
                element.setByteBuffer(elementBuffer);
            }

        } else {
            throw new MCCommsException("[MCCOMMS] Unexpected command! Expecting command code [" + this.expectedReplyCommand + "] but got command [" + commandReplyPacket.getCommand());
        }
    }
}
