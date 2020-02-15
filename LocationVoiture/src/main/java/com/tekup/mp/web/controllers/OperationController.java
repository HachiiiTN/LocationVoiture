package com.tekup.mp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tekup.mp.jpa.entities.Car;
import com.tekup.mp.jpa.entities.Operation;
import com.tekup.mp.metier.servicesImpl.CarService;
import com.tekup.mp.metier.servicesImpl.OperationService;

@Controller
public class OperationController {

	@Autowired
	private OperationService operationService;
	
	@Autowired
	private CarService carservice;
	
	@GetMapping("/operation/new")
    public String newOperationForm(Model model) {
		model.addAttribute(new Operation());
        model.addAttribute("cars", carservice.findByEtat("Disponible"));
		return "operation/addOperation";

	}
	
	@PostMapping("/operation/new")
    public String saveOperationController(Operation operation){
        operationService.saveOperation(operation);
        return "redirect:/operation/" + operation.getOperationID();
       
    }
	
	@GetMapping("/operation/{id}")
    public String showOperation(@PathVariable Long id, Model model) {
        model.addAttribute("operation", operationService.getOperationById(id));
		return "operation/showOperation";
    }
	
	@GetMapping("/operation/all")
	public String showAllOperations(Model model) {
	    model.addAttribute("operations", operationService.getAllOperations());
		return "operation/listOperations";
	}
	
	@GetMapping("/operation/{id}/delete")
	public String deleteOperation(@PathVariable Long id) {
		operationService.deleteOperationById(id);
		return "redirect:/operation/all";
	}
}
