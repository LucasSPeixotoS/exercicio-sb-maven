package com.springmaven.exerciciosbmaven.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {

    @RequestMapping(path = "hello")
    public String hello(){
        return "Hello Spring Boot!";
    }
}
