package com.premolexpert.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-word")
public class HelloWorld {
    @GetMapping
    public String hello(){
        return "Olá Mundo";
    }
}
