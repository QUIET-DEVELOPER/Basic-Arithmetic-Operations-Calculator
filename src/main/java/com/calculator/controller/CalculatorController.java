package com.calculator.controller;

import com.calculator.model.Calculator;
import com.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String showCalculator(Model model) {
        model.addAttribute("calculator", new Calculator());
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute Calculator calculator, Model model) {
        try {
            double result = calculatorService.calculate(
                calculator.getFirstNumber(),
                calculator.getSecondNumber(),
                calculator.getOperation()
            );
            calculator.setResult(result);
            model.addAttribute("calculator", calculator);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "calculator";
    }
}