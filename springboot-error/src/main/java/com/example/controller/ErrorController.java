package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @GetMapping("/showList")
    public String showList() {
        int i = 1/0;
        return "showList";
    }
    @GetMapping("/showAll")
    public String showAll() {
        return "showAll";
    }
}
