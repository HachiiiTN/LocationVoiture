package com.tekup.mp.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(Model model) {

        System.err.println("reached here");
        return "login";
    }

    @PostMapping("/login")
    public String didLogin() {
        return "redirect:/";
    }
}
