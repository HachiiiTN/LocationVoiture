package com.tekup.mp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tekup.mp.models.Car;
import com.tekup.mp.models.Operation;

@Controller
public class AppController {
	
	// Show home page
	@GetMapping({"/", "/home", "/index"})
    public String welcomePage(Model model) {
        model.addAttribute("title", "Home Page");
        model.addAttribute("message", "Welcome!");
        return "index";
    }
	

	//Show add new car form
	@GetMapping("/car/new")
    public String newCarForm(Model model) {
		model.addAttribute(new Car());
		return "car/addCar";
    }
	@GetMapping("/newOperation")
    public String newOperationForm(Model model) {
		model.addAttribute(new Operation());
		return "operation/addOperation";

	}
}
