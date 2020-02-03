package com.tekup.mp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tekup.mp.models.Voiture;
import com.tekup.mp.services.VoitureService;

@Controller
public class VoitureController {

	@Autowired
	private VoitureService voitureService;
	
	// Ajouter une voiture dans la base et afficher l'inforamtions 
	@PostMapping("/addVoiture")
    public String saveVoitureController(Voiture voiture){
        voitureService.saveVoiture(voiture);
        return "redirect:/voiture/" + voiture.getVoitureID();
    }
	
	// Afficher toutes les voituresq
	@GetMapping("/listVoitures")
    public String showAllVoiture(Model model) {
        model.addAttribute("voitures", voitureService.getAllVoitures());
		return "voiture/listVoitures";
    }
	
	// Afficher l'information de la voiture avec un id
	@GetMapping("/voiture/{id}")
    public String showVoiture(@PathVariable Long id, Model model) {
        model.addAttribute("voiture", voitureService.getVoitureById(id));
		return "voiture/afficherVoiture";
    }
}
