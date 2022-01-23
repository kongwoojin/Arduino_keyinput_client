package com.kongjak.arduinoclient;

import java.io.IOException;
import java.io.InputStream;

public class SerialReader implements Runnable {
    InputStream inputStream;

    public SerialReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
            while ((len = this.inputStream.read(buffer)) > -1) {
                System.out.print(new String(buffer, 0, len));
                KeyExecute macroExecute = new KeyExecute();
                macroExecute.key(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
