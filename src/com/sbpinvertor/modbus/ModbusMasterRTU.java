package com.sbpinvertor.modbus;

import com.sbpinvertor.modbus.exception.ModbusTransportException;
import com.sbpinvertor.modbus.net.ModbusConnection;
import com.sbpinvertor.modbus.net.ModbusConnectionRTU;
import com.sbpinvertor.modbus.net.ModbusTransport;
import com.sbpinvertor.modbus.net.ModbusTransportRTU;
import com.sbpinvertor.modbus.serial.SerialParameters;
import com.sbpinvertor.modbus.serial.SerialPort;
import com.sbpinvertor.modbus.serial.SerialUtils;

/**
 * Copyright (c) 2015-2016 JSC "Zavod "Invertor"
 * [http://www.sbp-invertor.ru]
 * <p/>
 * This file is part of JLibModbus.
 * <p/>
 * JLibModbus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * <p/>
 * Authors: Vladislav Y. Kochedykov, software engineer.
 * email: vladislav.kochedykov@gmail.com
 */

class ModbusMasterRTU extends ModbusMaster {

    final private ModbusTransport transport;
    final private ModbusConnection connection;

    public ModbusMasterRTU(SerialParameters parameters) throws ModbusTransportException {
        this.transport = new ModbusTransportRTU();
        this.connection = new ModbusConnectionRTU(SerialUtils.createSerial(parameters));
        connection.open();
    }

    public ModbusMasterRTU(String device, SerialPort.BaudRate baudRate, int dataBits, int stopBits, SerialPort.Parity parity) throws ModbusTransportException {
        this(new SerialParameters(device, baudRate, dataBits, stopBits, parity));
    }

    @Override
    protected ModbusTransport getTransport() {
        return transport;
    }

    @Override
    protected ModbusConnection getConnection() {
        return connection;
    }
}
