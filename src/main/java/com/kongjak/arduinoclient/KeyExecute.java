package com.kongjak.arduinoclient;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyExecute {
    public KeyExecute() {
        super();
    }

    public void key(String string) {
        if (string.equals("A")) {
            firstKey();
        } else if (string.equals("B")) {
            secondKey();
        }
    }

    public void firstKey() {
        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress((KeyEvent.VK_H));

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease((KeyEvent.VK_H));

        } catch (AWTException e) {
            e.printStackTrace();
        }


    }

    public void secondKey() {
        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress((KeyEvent.VK_M));

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease((KeyEvent.VK_M));

        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
}
