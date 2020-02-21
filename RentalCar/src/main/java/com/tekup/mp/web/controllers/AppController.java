package com.tekup.mp.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AppController {

	// Show home page
	@GetMapping({"/", "/home", "/index"})
    public String welcomePage(Model model) {
        model.addAttribute("title", "Homepage");
        model.addAttribute("message", "Welcome!");
        //model.addAttribute("role", USER_ROLE);
        return "index";
    }

	// Error pages goes here
}
