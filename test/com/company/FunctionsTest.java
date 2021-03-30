package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void isOperator() {
        List<Character> operators = Arrays.asList('+', '-', '*', '/', '^');
        for (char operator : operators){
            assertTrue(Functions.isOperator(operator));
        }
    }

    @Test void isNotOperator() {
        assertFalse(Functions.isOperator('x'));
    }

    @Test
    void simplePreFixToInfix() {
        String expected = "*+AB-CD";
        assertEquals(expected, Functions.generatePreFixToInfix("(A+B) * (C-D)"));
    }

    @Test
    void simplePostFixToInfix() {
        String expected = "AB+CD-*";
        assertEquals(expected, Functions.generatePostFixToInfix("(A+B) * (C-D)"));
    }

    @Test
    void simpleInfixToPostfix(){
        String expected = "AB+CD-*";
        assertEquals(expected, Functions.generateInfixToPostfix("(A+B) * (C-D)"));
    }

    @Test
    void simpleInfixToPrefix() {
        String expected = "AB+CD-*";
        assertEquals(expected, Functions.generateInfixToPrefix("(A+B) * (C-D)"));
    }

    @Test
    void simplePrefix(){
       String expected = "*+AB-CD";
       assertEquals(expected, Functions.generatePrefix("AB+CD-*"));
    }

    @Test
    void simplePostfix(){
        String expected = "AB+CD-*";
        assertEquals(expected, Functions.generatePostfix("*+AB-CD"));
    }
}