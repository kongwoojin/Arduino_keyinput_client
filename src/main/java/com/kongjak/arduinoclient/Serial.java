package com.kongjak.arduinoclient;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.InputStream;

public class Serial {

    SerialPort serialPort;

    public Serial() {
        super();
    }

    void connect(String portName) throws Exception {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if (portIdentifier.isCurrentlyOwned()) {
            System.out.println("Error: Port is currently in use");
        } else {
            CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

            if (commPort instanceof SerialPort) {
                serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(
                        9600,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE
                );

                InputStream in = serialPort.getInputStream();

                (new Thread(new SerialReader(in))).start();
            }
        }
    }

    /*
    Not Working
    */

    /*
    public void disconnect() {

        if (serialPort != null) {
            try {
                serialPort.removeEventListener();
                serialPort.close();
                serialPort.getInputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
     */

}