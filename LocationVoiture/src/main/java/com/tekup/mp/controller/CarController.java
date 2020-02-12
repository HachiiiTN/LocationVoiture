package com.tekup.mp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tekup.mp.models.Car;
import com.tekup.mp.services.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService carService;
	
	// Ajouter une voiture dans la base et afficher l'inforamtions 
	@PostMapping("/addCar")
    public String saveCarController(Car car){
		car.setEtat("Disponible");
        carService.saveCar(car); 
        return "redirect:/car/" + car.getCarID();
    }
	
	// Afficher toutes les voitures
	@GetMapping("/car/all")
    public String showAllCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
		return "car/listCars";
    }
	
	// Afficher l'information de la voiture avec un id
	@GetMapping("/car/{id}")
    public String showCar(@PathVariable Long id, Model model) {
        model.addAttribute("car", carService.getCarById(id));
		return "car/showCar";
    }
	// Supprimer une voiture
	@GetMapping("/car/{id}/delete")
	public String deleteCar(@PathVariable Long id) {
		carService.deleteCarById(id);
		return "redirect:/car/all";
	}
}
