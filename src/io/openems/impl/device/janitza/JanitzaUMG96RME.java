/*******************************************************************************
 * OpenEMS - Open Source Energy Management System
 * Copyright (c) 2016 FENECON GmbH and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *   FENECON GmbH - initial API and implementation and initial documentation
 *******************************************************************************/
package io.openems.impl.device.janitza;

import java.util.Set;

import io.openems.api.device.nature.DeviceNature;
import io.openems.api.exception.OpenemsException;
import io.openems.impl.protocol.modbus.ModbusDevice;

public class JanitzaUMG96RME extends ModbusDevice {

	public JanitzaUMG96RME() throws OpenemsException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override protected Set<DeviceNature> getDeviceNatures() {
		// TODO Auto-generated method stub
		return null;
	}

	// @IsDeviceNature
	// public JanitzaUMG96RMEMeter meter = null;
	//
	// public JanitzaUMG96RME() throws OpenemsException {
	// super();
	// }
	//
	// @IsConfig("meter")
	// public void setMeter(JanitzaUMG96RMEMeter meter) {
	// this.meter = meter;
	// }

}