package com.company;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel expLabel;
    private static JLabel resultLabel;
    private static JTextField expField;
    private static JTextField resultField;
    private static JButton preButton;
    private static JButton postButton;

    public GUI() {

        frame = new JFrame();
        frame.setTitle("Expression Converter");
        frame.setSize(350, 175);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        expLabel = new JLabel("Enter expression ");
        expLabel.setBounds(10, 20, 100, 25);

        expField = new JTextField(20);
        expField.setBounds(150, 20, 160, 25);

        preButton = new JButton("Prefix to Postfix");
        preButton.setBounds(20, 60, 125, 25);
        preButton.addActionListener(this); //prefix function

        postButton = new JButton("Postfix to Prefix");
        postButton.setBounds(170, 60, 125, 25);
        postButton.addActionListener(this); //postfix function
        resultLabel= new JLabel("Result");
        resultLabel.setBounds(10, 100, 100, 25);

        resultField = new JTextField();
        resultField.setBounds(150, 100, 160, 25);
        resultField.setBackground(Color.LIGHT_GRAY);

        panel = new JPanel();
        //panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        //panel.setLayout(new GridLayout(3, 2, 5, 5));
        panel.setLayout(null);
        panel.add(expLabel);
        panel.add(expField);
        panel.add(preButton);
        panel.add(postButton);
        panel.add(resultLabel);
        panel.add(resultField);

        frame.add(panel, BorderLayout.CENTER);
        //frame.pack(); Necessary?
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        Functions func = new Functions();

        if(e.getSource() == preButton) {
            String expression = expField.getText();
            if (expression.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a value", "Error", JOptionPane.ERROR_MESSAGE);
            }
            resultField.setText(func.postFix(expression));
        }
        else if (e.getSource() == postButton) {
            String expression = expField.getText();
            if (expression.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a value", "Error", JOptionPane.ERROR_MESSAGE);
            }
            resultField.setText(func.preFix(expression));
        }
        //String token = expField.getText();
        //System.out.println(token);
        //String user = userText.getText();
        //String password = passwordText.getText();
        //count++;
        //label.setText("Number of clicks: " + count);

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}