package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private static JTextField expField;
    private static JTextField resultField;
    private static JButton preButton;
    private static JButton postButton;

    public GUI() {

        JFrame frame = new JFrame();
        frame.setTitle("Expression Converter");
        frame.setSize(350, 175);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel expLabel = new JLabel("Enter expression ");
        expLabel.setBounds(10, 20, 100, 25);

        expField = new JTextField(20);
        expField.setBounds(150, 20, 160, 25);

        preButton = new JButton("Prefix to Postfix");
        preButton.setBounds(20, 60, 125, 25);
        preButton.addActionListener(this); //prefix function

        postButton = new JButton("Postfix to Prefix");
        postButton.setBounds(170, 60, 125, 25);
        postButton.addActionListener(this); //postfix function
        JLabel resultLabel = new JLabel("Result");
        resultLabel.setBounds(10, 100, 100, 25);

        resultField = new JTextField();
        resultField.setBounds(150, 100, 160, 25);
        resultField.setBackground(Color.LIGHT_GRAY);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(expLabel);
        panel.add(expField);
        panel.add(preButton);
        panel.add(postButton);
        panel.add(resultLabel);
        panel.add(resultField);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == preButton) {
            String expression = expField.getText();
            if (expression.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a value", "Error", JOptionPane.ERROR_MESSAGE);
            }
            resultField.setText(Functions.postFix(expression));
        }
        else if (e.getSource() == postButton) {
            String expression = expField.getText();
            if (expression.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a value", "Error", JOptionPane.ERROR_MESSAGE);
            }
            resultField.setText(Functions.preFix(expression));
        }
    }
}