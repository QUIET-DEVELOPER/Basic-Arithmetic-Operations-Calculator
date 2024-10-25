package com.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    
    public double calculate(double firstNumber, double secondNumber, String operation) {
        switch (operation) {
            case "add":
                return firstNumber + secondNumber;
            case "subtract":
                return firstNumber - secondNumber;
            case "multiply":
                return firstNumber * secondNumber;
            case "divide":
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return firstNumber / secondNumber;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
