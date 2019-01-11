package io.openems.edge.battery.soltaro.versionb;

public enum ModuleParameters {

	LEVEL_1_TOTAL_OVER_VOLTAGE_MILLIVOLT(43800), // address x2082
	LEVEL_1_TOTAL_OVER_VOLTAGE_RECOVER_MILLIVOLT(43200), // address x2083
	LEVEL_1_TOTAL_LOW_VOLTAGE_MILLIVOLT(33600), // address x2088
	LEVEL_1_TOTAL_LOW_VOLTAGE_RECOVER_MILLIVOLT(34200), // address x2089
	LEVEL_2_TOTAL_OVER_VOLTAGE_MILLIVOLT(44400), // address x2042
	LEVEL_2_TOTAL_OVER_VOLTAGE_RECOVER_MILLIVOLT(43800), // address x2043
	LEVEL_2_TOTAL_LOW_VOLTAGE_MILLIVOLT(32400), // address x2048
	LEVEL_2_TOTAL_LOW_VOLTAGE_RECOVER_MILLIVOLT(33000), // address x2049
	
	MIN_VOLTAGE_VOLT(34),
	MAX_VOLTAGE_VOLT(42)
	;
	
	private ModuleParameters(int value) {
		this.value = value;
	}
	
	private int value;

	public int getValue() {
		return this.value;
	}
	
}
