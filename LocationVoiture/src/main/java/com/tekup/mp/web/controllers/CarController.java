package com.tekup.mp.web.controllers;

import com.tekup.mp.web.model.requests.CarForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tekup.mp.jpa.entities.Car;
import com.tekup.mp.metier.servicesImpl.CarService;

import javax.validation.Valid;

@Controller()
public class CarController {

    @Autowired
    private CarService carService;

    // Show add new car form
    @GetMapping("/car/new")
    public String newCarForm(Model model) {
        model.addAttribute(new Car());
        return "car/addCar";
    }

    // Ajouter une voiture dans la base et afficher l'inforamtions
    @PostMapping("/car/new")
    public String saveCarController(Car car) {
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

    @GetMapping("/car/{id}/update")
    public String showUpdateCar(@PathVariable Long id, Model model) {
        if (id > 0) {
            for (Car car : carService.getAllCars()) {
                if (car.getCarID() == id) {
                    CarForm carForm = new CarForm();
                    carForm.setCarID(car.getCarID());
                    carForm.setImmatriculation(car.getImmatriculation());
                    carForm.setMarque(car.getMarque());
                    carForm.setModele(car.getModele());
                    carForm.setDateMiseCirculation(car.getDateMiseCirculation());
                    carForm.setPrixLocation(car.getPrixLocation());
                    carForm.setEtat(car.getEtat());
                    model.addAttribute("carForm", carForm);
                    return "car/updateCar";
                }
            }
        }
        return "redirect:/car/all";
    }

    @PostMapping("/car/{id}/update")
    public String updateCar(@RequestParam(value = "carID", required = true) Long id, @Valid @ModelAttribute("carForm") CarForm carForm) {
        for (Car car : carService.getAllCars()) {
            if (car.getCarID() == id) {
                car.setCarID(carForm.getCarID());
                car.setImmatriculation(carForm.getImmatriculation());
                car.setMarque(carForm.getMarque());
                car.setModele(carForm.getModele());
                car.setDateMiseCirculation(carForm.getDateMiseCirculation());
                car.setPrixLocation(carForm.getPrixLocation());
                car.setEtat(carForm.getEtat());

                carService.saveCar(car);
                return "redirect:/car/" + car.getCarID();
            }
        }
        return "redirect:/car/all";
    }

    // Supprimer une voiture
    @GetMapping("/car/{id}/delete")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
        return "redirect:/car/all";
    }
}
