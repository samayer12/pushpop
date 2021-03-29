package com.company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Functions implements ActionListener {

    static boolean isOperator(char op) {
        switch (op) {
            case '+', '-', '*', '/', '^' -> {
                return true;
            }
        }
        return false;
    }

    public static String generatePostFix(String expression) {

        Stack<String> operand = new Stack<>();
        int length = expression.length();
        StringBuilder prefixExpression = new StringBuilder();
        String temp;

        try {
            for (int i = 0; i < length; i++) {
                if (isOperator(expression.charAt(i))) {
                    String op1 = operand.peek();
                    operand.pop();
                    String op2 = operand.peek();
                    operand.pop();
                    temp = expression.charAt(i) + op1 + op2;
                    operand.push(temp);
                }
                else if (!isOperator(expression.charAt(i)) && !Character.isWhitespace(expression.charAt(i))) {
                    operand.push(expression.charAt(i) + " ");
                }
            }
            for (Object i : operand) {
                prefixExpression.append(i);
            }
        } catch (EmptyStackException e) {
            JOptionPane.showMessageDialog(null, "The stack is empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return prefixExpression.toString();
    }
    public static String generatePreFix(String expression) {

        Stack<String> operand = new Stack<>();
        int length = expression.length();
        String postfixExpression;
        String temp;

        for(int i = length-1; i >= 0; i--) {
            if (isOperator(expression.charAt(i))) {
                String op1 = operand.pop();
                String op2 = operand.pop();
                temp = op1 + op2 + expression.charAt(i);
                operand.push(temp);
            }
            else {
                operand.push(String.valueOf(expression.charAt(i)));
            }
        }
        postfixExpression = operand.pop();
        return postfixExpression;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
