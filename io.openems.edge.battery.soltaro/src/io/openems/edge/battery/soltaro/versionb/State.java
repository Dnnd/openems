package io.openems.edge.battery.soltaro.versionb;

import io.openems.edge.common.channel.doc.OptionsEnum;

public enum State implements OptionsEnum {
	UNDEFINED(-1, "Undefined"),
//	PENDING("Pending", 0),
	OFF(1, "Off"),
	INIT(2, "Initializing"),
	RUNNING(3, "Running"),
	STOPPING(4, "Stopping"),
	ERROR(5, "Error"),
	ERRORDELAY(6, "Errordelay"),
//	CONFIGURING("Configuring", 7);
	;
	
	private final int value;
	private final String name;

	private State(int value, String name) {
		this.value = value;
		this.name = name;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public OptionsEnum getUndefined() {
		return UNDEFINED;
	}
	
}
