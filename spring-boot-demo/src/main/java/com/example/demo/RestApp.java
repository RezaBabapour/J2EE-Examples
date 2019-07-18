package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class RestApp {

    @GetMapping("/")
    public String sayHello()
    {
        return "Hello Dude" + LocalDateTime.now();
    }
}
