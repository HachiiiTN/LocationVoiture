package com.tekup.mp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tekup.mp.models.Voiture;

@Controller
public class AppController {
	
	// Show home page
	@GetMapping({"/", "/home", "/index"})
    public String welcomePage(Model model) {
        model.addAttribute("title", "Home Page");
        model.addAttribute("message", "Welcome!");
        return "index";
    }
	
	//Show add new voiture form
	@GetMapping("/newVoiture")
    public String newVoitureForm(Model model) {
		model.addAttribute(new Voiture());
		return "voiture/ajouterVoiture";
    }
}
