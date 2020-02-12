package com.tekup.mp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tekup.mp.models.Car;
import com.tekup.mp.models.Operation;
import com.tekup.mp.services.CarService;

@Controller
public class AppController {
	@Autowired
	private CarService carservice;
	
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
	@GetMapping("/operation/new")
    public String newOperationForm(Model model) {
		model.addAttribute(new Operation());
        model.addAttribute("cars", carservice.findByEtat("Disponible"));
		return "operation/addOperation";

	}
}
