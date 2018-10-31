package io.openems.edge.sma;

import java.util.Arrays;
import java.util.stream.Stream;

import io.openems.edge.common.channel.AbstractReadChannel;
import io.openems.edge.common.channel.IntegerReadChannel;
import io.openems.edge.common.channel.IntegerWriteChannel;
import io.openems.edge.common.channel.LongReadChannel;
import io.openems.edge.common.channel.LongWriteChannel;
import io.openems.edge.common.channel.StateCollectorChannel;
import io.openems.edge.common.component.OpenemsComponent;
import io.openems.edge.ess.api.ManagedSymmetricEss;
import io.openems.edge.ess.api.SinglePhaseEss;
import io.openems.edge.ess.api.SymmetricEss;

public class Utils {
	public static Stream<? extends AbstractReadChannel<?>> initializeChannels(SunnyIsland6Ess c) {
		return Stream.of( //
				Arrays.stream(OpenemsComponent.ChannelId.values()).map(channelId -> {
					switch (channelId) {
					case STATE:
						return new StateCollectorChannel(c, channelId);
					}
					return null;
				}), Arrays.stream(SymmetricEss.ChannelId.values()).map(channelId -> {
					switch (channelId) {
					case SOC:
					case ACTIVE_POWER:
					case REACTIVE_POWER:
					case ACTIVE_CHARGE_ENERGY:
					case ACTIVE_DISCHARGE_ENERGY:
						return new IntegerReadChannel(c, channelId);
					case MAX_APPARENT_POWER:
						return new IntegerReadChannel(c, channelId, SunnyIsland6Ess.MAX_APPARENT_POWER);
					case GRID_MODE:
						return new IntegerReadChannel(c, channelId, SymmetricEss.GridMode.ON_GRID);
					}
					return null;
				}), Arrays.stream(ManagedSymmetricEss.ChannelId.values()).map(channelId -> {
					switch (channelId) {
					case ALLOWED_CHARGE_POWER:
					case ALLOWED_DISCHARGE_POWER:
					case DEBUG_SET_ACTIVE_POWER:
					case DEBUG_SET_REACTIVE_POWER:
						return new IntegerReadChannel(c, channelId);
					}
					return null;
				}), Arrays.stream(SinglePhaseEss.ChannelId.values()).map(channelId -> {
					switch (channelId) {
					case PHASE:
						return new IntegerReadChannel(c, channelId);
					}
					return null;
				}), Arrays.stream(SunnyIsland6Ess.ChannelId.values()).map(channelId -> {
					switch (channelId) {
//					case TOTAL_YIELD:
					case SYSTEM_STATE:
					case BATTERY_TEMPERATURE:
					case BATTERY_VOLTAGE:
					case FREQUENCY:
					case OPERATING_MODE_FOR_ACTIVE_POWER:
					case OPERATING_MODE_FOR_REACTIVE_POWER:
					case ABSORBED_ENERGY:
					case AMP_HOURS_COUNTER_FOR_BATTERY_CHARGE:
					case AMP_HOURS_COUNTER_FOR_BATTERY_DISCHARGE:
					case DEVICE_CLASS:
					case DEVICE_TYPE:
					case ENERGY_CONSUMED_FROM_GRID:
					case ENERGY_FED_INTO_GRID:
					case FAULT_CORRECTION_MEASURE:
					case GRID_FEED_IN_COUNTER_READING:
					case GRID_REFERENCE_COUNTER_READING:
					case MESSAGE:
					case METER_READING_CONSUMPTION_METER:
					case NUMBER_OF_EVENT_FOR_INSTALLER:
					case NUMBER_OF_EVENT_FOR_SERVICE:
					case NUMBER_OF_EVENT_FOR_USER:
					case NUMBER_OF_GENERATORS_STARTS:
					case NUMBER_OF_GRID_CONNECTIONS:
					case POWER_OUTAGE:
					case RECOMMENDED_ACTION:
					case RELEASED_ENERGY:
					case RISE_IN_SELF_CONSUMPTION:
					case RISE_IN_SELF_CONSUMPTION_TODAY:
					case SERIAL_NUMBER:
					case SOFTWARE_PACKAGE:
					case WAITING_TIME_UNTIL_FEED_IN:
					case ACTIVE_POWER_L1:
					case ACTIVE_POWER_L2:
					case ACTIVE_POWER_L3:
					case GRID_VOLTAGE_L1:
					case GRID_VOLTAGE_L2:
					case GRID_VOLTAGE_L3:
					case REACTIVE_POWER_L1:
					case REACTIVE_POWER_L2:
					case REACTIVE_POWER_L3:
					case COSPHI_SET_POINT_READ:
					case ACTIVE_BATTERY_CHARGING_MODE:
					case BATTERY_MAINT_SOC:
					case CURRENT_BATTERY_CAPACITY:
					case CURRENT_BATTERY_CHARGING_SET_VOLTAGE:
					case NUMBER_OF_BATTERY_CHARGE_THROUGHPUTS:
					case CURRENT_RISE_IN_SELF_CONSUMPTION:
					case CURRENT_SELF_CONSUMPTION:
					case LOAD_POWER:
					case POWER_GRID_FEED_IN:
					case POWER_GRID_REFERENCE:
					case PV_POWER_GENERATED:
					case MULTIFUNCTION_RELAY_STATUS:
					case POWER_SUPPLY_STATUS:
					case PV_MAINS_CONNECTION:
					case REASON_FOR_GENERATOR_REQUEST:
					case STATUS_OF_UTILITY_GRID:
					case CURRENT_EXTERNAL_POWER_CONNECTION_PHASE_A:
					case CURRENT_EXTERNAL_POWER_CONNECTION_PHASE_B:
					case CURRENT_EXTERNAL_POWER_CONNECTION_PHASE_C:
					case GRID_FREQ_OF_EXTERNAL_POWER_CONNECTION:
					case VOLTAGE_EXTERNAL_POWER_CONNECTION_PHASE_A:
					case VOLTAGE_EXTERNAL_POWER_CONNECTION_PHASE_B:
					case VOLTAGE_EXTERNAL_POWER_CONNECTION_PHASE_C:
					case DATA_TRANSFER_RATE_OF_NETWORK_TERMINAL_A:
					case GENERATOR_STATUS:
					case DUPLEX_MODE_OF_NETWORK_TERMINAL_A:
					case TOTAL_CURRENT_EXTERNAL_GRID_CONNECTION:
					case GRID_CURRENT_L1:
					case GRID_CURRENT_L2:
					case GRID_CURRENT_L3:
					case OUTPUT_OF_PHOTOVOLTAICS:
					case FAULT_BATTERY_SOC:
					case CHARGE_FACTOR_RATIO_OF_BATTERY_CHARGE_DISCHARGE:
					case HIGHEST_MEASURED_BATTERY_TEMPERATURE:
					case LOWER_DISCHARGE_LIMIT_FOR_SELF_CONSUMPTION_RANGE:
					case LOWEST_MEASURED_BATTERY_TEMPERATURE:
					case MAXIMUM_BATTERY_CURRENT_IN_CHARGE_DIRECTION:
					case MAXIMUM_BATTERY_CURRENT_IN_DISCHARGE_DIRECTION:
					case MAX_OCCURRED_BATTERY_VOLTAGE:
					case OPERATING_STATUS_MASTER_L1:
					case OPERATING_TIME_OF_BATTERY_STATISTICS_COUNTER:
					case REMAINING_ABSORPTION_TIME:
					case REMAINING_MIN_OPERATING_TIME_OF_GENERATOR:
					case REMAINING_TIME_UNTIL_EQUALIZATION_CHARGE:
					case REMAINING_TIME_UNTIL_FULL_CHARGE:
					case TOTAL_OUTPUT_CURRENT_OF_SOLAR_CHARGER:
					case ABSORPTION_PHASE_ACTIVE:
					case BATTERY_TYPE:
					case CONTROL_OF_BATTERY_CHARGING_VIA_COMMUNICATION_AVAIULABLE:
					case FIRMWARE_VERSION_OF_THE_LOGIC_COMPONENET:
					case FIRMWARE_VERSION_OF_THE_MAIN_PROCESSOR:
					case MAX_BATTERY_TEMPERATURE:
					case NUMBER_OF_EQALIZATION_CHARGES:
					case NUMBER_OF_FULL_CHARGES:
					case OPERATING_TIME_ENERGY_COUNT:
					case OUTPUT_EXTERNAL_POWER_CONNECTION:
					case OUTPUT_EXTERNAL_POWER_CONNECTION_L1:
					case OUTPUT_EXTERNAL_POWER_CONNECTION_L2:
					case OUTPUT_EXTERNAL_POWER_CONNECTION_L3:
					case PHOTOVOLTAIC_ENERGY_IN_SOLAR_CHARGER:
					case RATED_BATTERY_CAPACITY:
					case RATED_BATTERY_VOLTAGE:
					case REACTIVE_POWER_EXTERNAL_POWER_CONNECTION:
					case REACTIVE_POWER_EXTERNAL_POWER_CONNECTION_L1:
					case REACTIVE_POWER_EXTERNAL_POWER_CONNECTION_L2:
					case REACTIVE_POWER_EXTERNAL_POWER_CONNECTION_L3:
					case RELATIVE_BATTERY_DISCHARGING_SINCE_LAST_EQUALIZATION_CHARGE:
					case RELATIVE_BATTERY_DISCHARGING_SINCE_THE_LAST_FULL_CHARGE:
					case STATUS_BATTERY_APPLICATION_AREA:
					case STATUS_DIGITAL_INPUT:
					case TOTAL_ENERGY_PHOTOVOLTAICS:
					case TOTAL_ENERGY_PHOTOVOLTAICS_CURRENT_DAY:
						return new IntegerReadChannel(c, channelId);

					case BATTERY_CHARGING_SOC:
					case BATTERY_DISCHARGING_SOC:
					case SPEED_WIRE_CONNECTION_STATUS_OF_NETWORK_TERMINAL_A:
						return new LongReadChannel(c, channelId);

					case BMS_OPERATING_MODE:
					case MIN_SOC_POWER_ON:
					case MIN_SOC_POWER_OFF:
					case METER_SETTING:
					case SET_CONTROL_MODE:
					case SET_REACTIVE_POWER:
					case SET_ACTIVE_POWER:
					
					case GRID_GUARD_CODE:
					case BATTERY_BOOST_CHARGE_TIME:
					case BATTERY_EQUALIZATION_CHARGE_TIME:
					case BATTERY_FULL_CHARGE_TIME:
					case RATED_GENERATOR_CURRENT:
					case AUTOMATIC_GENERATOR_START:
					case MANUAL_GENERATOR_CONTROL:
					case GENERATOR_REQUEST_VIA_POWER_ON:
					case GENERATOR_SHUT_DOWN_LOAD_LIMIT:
					case GENERATOR_START_UP_LOAD_LIMIT:
					case GRID_CREATING_GENERATOR:
					case RISE_IN_SELF_CONSUMPTION_SWITCHED_ON:
					case CELL_CHARGE_NOMINAL_VOLTAGE_FOR_BOOST_CHARGE:
					case CELL_CHARGE_NOMINAL_VOLTAGE_FOR_EQUALIZATION_CHARGE:
					case CELL_CHARGE_NOMINAL_VOLTAGE_FOR_FLOAT_CHARGE:
					case CELL_CHARGE_NOMINAL_VOLTAGE_FOR_FULL_CHARGE:
					case VOLTAGE_MONITORING_HYSTERESIS_MAXIMUM_THRESHOLD:
					case VOLTAGE_MONITORING_HYSTERESIS_MINIMUM_THRESHOLD:
					case VOLTAGE_MONITORING_UPPER_MAXIMUM_THRESHOLD:
					case VOLTAGE_MONITORING_UPPER_MINIMUM_THRESHOLD:
					case FREQUENCY_MONITORING_HYSTERESIS_MINIMUM_THRESHOLD:
					case FREQUENCY_MONITORING_HYSTERESIS_MAXIMUM_THRESHOLD:
					case FREQUENCY_MONITORING_UPPER_MAXIMUM_THRESHOLD:
					case FREQUENCY_MONITORING_UPPER_MINIMUM_THRESHOLD:
					case MAX_BATTERY_CHARGING_CURRENT:
						return new IntegerWriteChannel(c, channelId);

					case MAXIMUM_BATTERY_CHARGING_POWER:
					case MAXIMUM_BATTERY_DISCHARGING_POWER:
					case INITIATE_DEVICE_RESTART:
						return new LongWriteChannel(c, channelId);
					}
					return null;
				})).flatMap(channel -> channel);
	}
}
