package com.example.Application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @GetMapping("/")
    public String main(){
        return "mainpage";
    }

    @GetMapping("/registerpage")
    public String register(){
        return "registerpage";
    }

    @GetMapping("/loginpage")
    public String login(){
        return "loginpage";
    }
}
