package com.tekup.mp.web.controllers;

import com.tekup.mp.web.model.requests.CarForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tekup.mp.jpa.entities.Car;
import com.tekup.mp.metier.servicesImpl.CarServiceImpl;

import javax.validation.Valid;

@Controller()
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarServiceImpl carServiceImpl;

    // Show add new car form
    @GetMapping("/new")
    public String newCarForm(Model model) {
        model.addAttribute(new Car());
        return "car/addCar";
    }

    // Ajouter une voiture dans la base et afficher l'inforamtions
    @PostMapping("/new")
    public String saveCarController(Car car) {
        car.setEtat("Disponible");
        carServiceImpl.saveCar(car);
        return "redirect:/car/" + car.getCarID();
    }

    // Afficher toutes les voitures
    @GetMapping("/all")
    public String showAllCars(Model model) {
        model.addAttribute("cars", carServiceImpl.getAllCars());
        return "car/listCars";
    }

    // Afficher l'information de la voiture avec un id
    @GetMapping("/{id}")
    public String showCar(@PathVariable Long id, Model model) {
        model.addAttribute("car", carServiceImpl.getCarById(id));
        return "car/showCar";
    }

    @GetMapping("/{id}/update")
    public String showUpdateCar(@PathVariable Long id, Model model) {
        if (id > 0) {
            for (Car car : carServiceImpl.getAllCars()) {
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

    @PostMapping("/{id}/update")
    public String updateCar(@RequestParam(value = "carID", required = true) Long id, @Valid @ModelAttribute("carForm") CarForm carForm) {
        for (Car car : carServiceImpl.getAllCars()) {
            if (car.getCarID() == id) {
                car.setCarID(carForm.getCarID());
                car.setImmatriculation(carForm.getImmatriculation());
                car.setMarque(carForm.getMarque());
                car.setModele(carForm.getModele());
                car.setDateMiseCirculation(carForm.getDateMiseCirculation());
                car.setPrixLocation(carForm.getPrixLocation());
                car.setEtat(carForm.getEtat());

                carServiceImpl.saveCar(car);
                return "redirect:/car/" + car.getCarID();
            }
        }
        return "redirect:/car/all";
    }

    // Supprimer une voiture
    @GetMapping("/{id}/delete")
    public String deleteCar(@PathVariable Long id) {
        carServiceImpl.deleteCarById(id);
        return "redirect:/car/all";
    }
}
