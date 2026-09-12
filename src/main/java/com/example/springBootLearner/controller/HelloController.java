package com.example.springBootLearner.controller;

import com.example.springBootLearner.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping
public class HelloController {

    @GetMapping("hello")
    public String sayHello() {
        return "Hello World!!";
    }
}
