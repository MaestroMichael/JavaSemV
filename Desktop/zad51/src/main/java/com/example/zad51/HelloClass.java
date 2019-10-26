package com.example.zad51;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloClass {
    @RequestMapping("/hello")
    public String hello(){
        String hi="Witaj mamy właśnie godzine:  "+ LocalDateTime.now();
        return hi;
    }
}
