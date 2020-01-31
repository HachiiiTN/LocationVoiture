package com.tekup.mp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tekup.mp.models.Voiture;
import com.tekup.mp.repository.VoitureRepository;
import com.tekup.mp.services.VoitureService;

@Controller
public class OperationController {

	@Autowired
	private VoitureService voitureService; 
	
	@GetMapping({"/", "/home", "/index"})
    public String welcomePage(Model model) {
        model.addAttribute("title", "Home Page");
        model.addAttribute("message", "Welcome!");
        return "index";
    }
	
	@GetMapping("/addVoiture")
    public String addVoitureForm(Voiture voiture) {
        return "voiture/addVehicule";
    }
	
	@PostMapping("/posAddVoiture")
    public String addVoitureToDatabase(Voiture voiture){
		
        voitureService.addVoiture(voiture);
		return "voiture/showVehicule";
    }
	
}
