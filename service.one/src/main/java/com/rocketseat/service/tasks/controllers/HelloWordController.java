package com.rocketseat.service.tasks.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @Value("${message: Hello default}")
    private String message;

    @GetMapping("/welcome")
    public String helloWord() {
        return "<h2>" + this.message + "</h2>";
    }
}
