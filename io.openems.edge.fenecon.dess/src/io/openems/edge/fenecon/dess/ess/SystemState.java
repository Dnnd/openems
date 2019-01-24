package io.openems.edge.fenecon.dess.ess;

import io.openems.edge.common.channel.doc.OptionsEnum;

public enum SystemState implements OptionsEnum {
	UNDEFINED(-1, "Undefined"), //
	INIT(0, "Initialization"), //
	STANDBY(1, "Standby"), //
	STARTING(2, "Starting"), //
	RUNNING(3, "Running"), //
	FAULT(4, "Fault");

	private final int value;
	private final String name;

	private SystemState(int value, String name) {
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