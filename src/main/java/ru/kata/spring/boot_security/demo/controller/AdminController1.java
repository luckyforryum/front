package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController1 {
    @GetMapping("/")
    public String adminPage() {
        return "index";
    }


}
