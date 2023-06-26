package com.example._183_abschlussprojekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {
    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/secret")
    String secret(){
        return "secret";
    }
}