package io.openems.backend.edgewebsocket.impl;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.java_websocket.WebSocket;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;

import io.openems.backend.common.component.AbstractOpenemsBackendComponent;
import io.openems.backend.edgewebsocket.api.EdgeWebsocket;
import io.openems.backend.metadata.api.Metadata;
import io.openems.backend.timedata.api.Timedata;
import io.openems.backend.uiwebsocket.api.UiWebsocket;
import io.openems.common.exceptions.OpenemsError;
import io.openems.common.exceptions.OpenemsError.OpenemsNamedException;
import io.openems.common.exceptions.OpenemsException;
import io.openems.common.jsonrpc.base.JsonrpcNotification;
import io.openems.common.jsonrpc.base.JsonrpcRequest;
import io.openems.common.jsonrpc.base.JsonrpcResponseSuccess;
import io.openems.common.jsonrpc.notification.SystemLogNotification;
import io.openems.common.jsonrpc.request.SubscribeSystemLogRequest;

@Designate(ocd = Config.class, factory = false)
@Component(name = "Edge.Websocket", configurationPolicy = ConfigurationPolicy.REQUIRE, immediate = true)
public class EdgeWebsocketImpl extends AbstractOpenemsBackendComponent implements EdgeWebsocket {

	// private final Logger log = LoggerFactory.getLogger(EdgeWebsocketImpl.class);

	private WebsocketServer server = null;

	private final SystemLogHandler systemLogHandler;

	@Reference
	protected volatile Metadata metadata;

	@Reference
	protected volatile Timedata timedata;

	@Reference(cardinality = ReferenceCardinality.OPTIONAL)
	protected volatile UiWebsocket uiWebsocket;

	public EdgeWebsocketImpl() {
		super("Edge.Websocket");
		this.systemLogHandler = new SystemLogHandler(this);
	}

	@Activate
	void activate(Config config) {
		this.startServer(config.port());
	}

	@Deactivate
	void deactivate() {
		this.stopServer();
	}

	/**
	 * Create and start new server.
	 * 
	 * @param port the port
	 */
	private synchronized void startServer(int port) {
		this.server = new WebsocketServer(this, this.getName(), port);
		this.server.start();
	}

	/**
	 * Stop existing websocket server.
	 */
	private synchronized void stopServer() {
		if (this.server != null) {
			this.server.stop();
		}
	}

	/**
	 * Gets whether the Websocket for this Edge is connected.
	 * 
	 * @param edgeId the Edge-ID
	 * @return true if it is online
	 */
	protected boolean isOnline(String edgeId) {
		return this.server.isOnline(edgeId);
	}

	@Override
	public CompletableFuture<JsonrpcResponseSuccess> send(String edgeId, JsonrpcRequest request)
			throws OpenemsNamedException {
		WebSocket ws = this.getWebSocketForEdgeId(edgeId);
		if (ws != null) {
			WsData wsData = ws.getAttachment();
			return wsData.send(request);
		} else {
			throw OpenemsError.BACKEND_EDGE_NOT_CONNECTED.exception(request.getId(), edgeId);
		}
	}

	@Override
	public void send(String edgeId, JsonrpcNotification notification) throws OpenemsException {
		WebSocket ws = this.getWebSocketForEdgeId(edgeId);
		if (ws != null) {
			WsData wsData = ws.getAttachment();
			wsData.send(notification);
		}
	}

	/**
	 * Gets the WebSocket connection for an Edge-ID. If more than one connection
	 * exists, the first one is returned. Returns null if none is found.
	 * 
	 * @param edgeId the Edge-ID
	 * @return the WebSocket connection
	 */
	private final WebSocket getWebSocketForEdgeId(String edgeId) {
		for (WebSocket ws : this.server.getConnections()) {
			WsData wsData = ws.getAttachment();
			Optional<String> wsEdgeId = wsData.getEdgeId();
			if (wsEdgeId.isPresent() && wsEdgeId.get().equals(edgeId)) {
				return ws;
			}
		}
		return null;
	}

	@Override
	protected void logInfo(Logger log, String message) {
		super.logInfo(log, message);
	}

	@Override
	protected void logWarn(Logger log, String message) {
		super.logWarn(log, message);
	}

	@Override
	public CompletableFuture<JsonrpcResponseSuccess> handleSubscribeSystemLogRequest(String edgeId, UUID token,
			SubscribeSystemLogRequest request) throws OpenemsNamedException {
		return this.systemLogHandler.handleSubscribeSystemLogRequest(edgeId, token, request);
	}

	/**
	 * Handles a {@link SystemLogNotification}, i.e. the replies to
	 * {@link SubscribeSystemLogRequest}.
	 * 
	 * @param edgeId       the Edge-ID
	 * @param notification the SystemLogNotification
	 */
	public void handleSystemLogNotification(String edgeId, SystemLogNotification notification) {
		this.systemLogHandler.handleSystemLogNotification(edgeId, notification);
	}
}
