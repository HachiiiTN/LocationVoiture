package com.tekup.mp.web.controllers;

import com.tekup.mp.web.model.requests.CarForm;
import com.tekup.mp.web.model.requests.OperationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tekup.mp.jpa.entities.Car;
import com.tekup.mp.jpa.entities.Operation;
import com.tekup.mp.metier.servicesImpl.CarService;
import com.tekup.mp.metier.servicesImpl.OperationService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OperationController {

    @Autowired
    private OperationService operationService;

    @Autowired
    private CarService carService;

    @GetMapping("/operation/new")
    public String newOperationForm(Model model) {
        model.addAttribute(new Operation());
        model.addAttribute("condition", "stepOne");
        return "operation/addOperation";
    }

    @PostMapping("/operation/new")
    public String addOperation(Operation operation) {
        operationService.saveOperation(operation);
        return "redirect:/operation/" + operation.getOperationID() + "/car";
    }

    @GetMapping("/operation/{id}/car")
    public String addCarSelection(@PathVariable Long id, Model model) {
        List<Car> listCar = new ArrayList<>();
        model.addAttribute("condition", "stepTwo");
        model.addAttribute("operationID", id);
        for (Car car : carService.getAllCars()) {
            listCar.add(car);
        }
        model.addAttribute("listCars", listCar);
        System.err.println("List : " + listCar);
        return "operation/addOperation";
    }

    @PostMapping("/operation/{id}/car/{idCar}")
    public String addCarIntoOperation(@PathVariable Long id, @PathVariable Long idCar) {
        Operation operation = operationService.getOperationById(id);
        operation.setCar(carService.getCarById(idCar));
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

    @GetMapping("/operation/{id}/update")
    public String showUpdateOperation(@PathVariable Long id, Model model) {
        if (id > 0) {
            for (Operation operation : operationService.getAllOperations()) {
                if (operation.getOperationID() == id) {
                    OperationForm operationForm = new OperationForm();
                    operationForm.setOperationID(operation.getOperationID());
                    //operationForm.setCar(operation.getCar());
                    operationForm.setDateDebut(operation.getDateDebut());
                    operationForm.setDateFin(operation.getDateFin());
                    operationForm.setFraisLocation(operation.getFraisLocation());
                    operationForm.setMontantGarantie(operation.getMontantGarantie());
                    operationForm.setTypeGarantie(operation.getTypeGarantie());
                    operationForm.setTypePayement(operation.getTypePayement());

                    System.err.println(operation.getCar().toString());

                    model.addAttribute("operationForm", operationForm);
                    model.addAttribute("operationCar", operation.getCar().toString());
                    return "operation/updateOperation";
                }
            }
        }
        return "redirect:/operation/all";
    }

    @PostMapping("/operation/{id}/update")
    public String updateOperation(@PathVariable Long id, @Valid @ModelAttribute("operationForm") OperationForm operationForm) {
        System.err.println(id);
        for (Operation operation : operationService.getAllOperations()) {
            if (operation.getOperationID() == id) {
                System.err.println(id);
                System.err.println(operationForm.getOperationID());
                operation.setOperationID(operationForm.getOperationID());
                //operation.setCar(operationForm.getCar());
                operation.setDateDebut(operationForm.getDateDebut());
                operation.setDateFin(operationForm.getDateFin());
                operation.setFraisLocation(operationForm.getFraisLocation());
                operation.setMontantGarantie(operationForm.getMontantGarantie());
                operation.setTypeGarantie(operationForm.getTypeGarantie());
                operation.setTypePayement(operationForm.getTypePayement());

                operationService.saveOperation(operation);
                return "redirect:/operation/" + operation.getOperationID();
            }
        }
        return "redirect:/operation/all";
    }

    @GetMapping("/operation/{id}/delete")
    public String deleteOperation(@PathVariable Long id) {
        operationService.deleteOperationById(id);
        return "redirect:/operation/all";
    }
}
