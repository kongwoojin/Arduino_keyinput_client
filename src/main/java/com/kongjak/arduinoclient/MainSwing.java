package com.kongjak.arduinoclient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainSwing extends JFrame implements ActionListener {

    JButton button;
    String buttonText = "Turn On";

    public MainSwing() {
        setTitle("Hello");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new FlowLayout());

        button = new JButton(buttonText);
        button.addActionListener(this);

        contentPane.add(button);
        setSize(200, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainSwing();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            serialOn();
            button.setVisible(false);
        }
    }

    public void serialOn() {
        try {
            Serial serial = new Serial();
            serial.connect("COM7"); // Hard coded. Will fix later
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
