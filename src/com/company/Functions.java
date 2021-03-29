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

    public static String preFix(String expression) {

        Stack operand = new Stack();
        int length = expression.length();
        String prefixExpression = "";
        String temp;

        try {
            for (int i = 0; i < length; i++) {
                if (Character.isWhitespace(expression.charAt(i)) == true ) {
                }
                else if (!isOperator(expression.charAt(i))) {
                    operand.push(expression.charAt(i) + " ");
                }
                else if (isOperator(expression.charAt(i))) {
                    String op1 = (String) operand.peek();
                    operand.pop();
                    String op2 = (String) operand.peek();
                    operand.pop();
                    temp = expression.charAt(i) + op1 + op2;
                    operand.push(temp);
                }
            }
            for (Object i : operand) {
                prefixExpression += i;
            }
        } catch (EmptyStackException e) {
            JOptionPane.showMessageDialog(null, "The stack is empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return prefixExpression;
    }
    public static String postFix(String expression) {

        Stack operand = new Stack();
        int length = expression.length();
        String postfixExpression = "";
        String temp;

        for(int i = length-1; i >= 0; i--) {
            if (isOperator(expression.charAt(i))) {
                String op1 = (String) operand.pop();
                String op2 = (String) operand.pop();
                temp = op1 + op2 + expression.charAt(i);
                operand.push(temp);
            }
            else {
                operand.push(expression.charAt(i));
            }
        }
        postfixExpression = (String) operand.pop();
        return postfixExpression;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
