package com.springmaven.exerciciosbmaven.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {

    @GetMapping(path = "/sum/{num1}/{num2}")
    public int sum(@PathVariable int num1, @PathVariable int num2){
        return num1 + num2;
    }

    @GetMapping(path = "/subtraction")// /subtraction?num1=10&num2=5
    public int subtraction(@RequestParam(name = "num1") int num1, @RequestParam(name = "num2") int num2){
        return num1 - num2;
    }//Subtraction é usado calculator/subtraction?num1=10&num2=5

    @GetMapping(path = "/multiplication")// /multiplication?num1=10.5&num2=5
    public double multiplication(@RequestParam(name = "num1") double num1, @RequestParam(name = "num2") double num2){
        return num1 * num2;
    }

    @GetMapping(path = "/division/{num1}/{num2}")
    public double division(@PathVariable double num1, @PathVariable double num2){
        return num1 / num2;
    }

}
