package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Functions implements ActionListener {

    static boolean isOperator(char op) {
        switch (op) {
            case '+', '-', '*', '/', '^' -> {
                return true;
            }
        }
        return false;
    }

    public static String generatePostfix(String expression) {
        Stack<String> s = new Stack<>();

        // read from right to left
        for (int i = expression.length() - 1; i >= 0; i--) {
            if (isOperator(expression.charAt(i))) {
                // pop two operands from stack
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();

                // concat the operands and operator
                String temp = op1 + op2 + expression.charAt(i);
                s.push(temp);
            }
            // symbol is an operand
            else {
                s.push(expression.charAt(i) + "");
            }
        }
        return s.peek();
    }

    public static String generatePrefix(String expression) {

        Stack<String> s = new Stack<>();

        // reading from right to left
        for (int i = 0; i < expression.length(); i++) {
            if (isOperator(expression.charAt(i))) {
                // pop two operands from stack
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();

                // concat the operands and operator
                String temp = expression.charAt(i) + op2 + op1;
                s.push(temp);
            }

            // symbol is an operand
            else {
                s.push(expression.charAt(i) + "");
            }
        }

        StringBuilder answer = new StringBuilder();
        for (String i : s)
            answer.append(i);
        return answer.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templateoperand.
    }

}
