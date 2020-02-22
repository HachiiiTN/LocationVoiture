package com.tekup.mp.web.controllers;

import com.tekup.mp.web.model.requests.OperationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tekup.mp.jpa.entities.Car;
import com.tekup.mp.jpa.entities.Operation;
import com.tekup.mp.metier.servicesImpl.CarServiceImpl;
import com.tekup.mp.metier.servicesImpl.OperationServiceImpl;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OperationController {

    private static String OPERATION_ERROR = "";

    @Autowired
    private OperationServiceImpl operationServiceImpl;

    @Autowired
    private CarServiceImpl carServiceImpl;

    @GetMapping("/operation/new")
    public String newOperationForm(Model model) {
        model.addAttribute(new Operation());
        model.addAttribute("error", OPERATION_ERROR);
        model.addAttribute("condition", "stepOne");
        return "operation/addOperation";
    }

    @PostMapping("/operation/new")
    public String addOperation(Operation operation) {
        OPERATION_ERROR = "";
        operationServiceImpl.saveOperation(operation);
        return "redirect:/operation/" + operation.getOperationID() + "/car";
    }

    @GetMapping("/operation/{id}/car")
    public String addCarSelection(@PathVariable Long id, Model model) {
        List<Car> listCar = new ArrayList<>();
        Operation newOperation = operationServiceImpl.getOperationById(id);

        for (Car car : carServiceImpl.getAllCars()) {
            listCar.add(car);
            for (Operation operation : operationServiceImpl.getAllOperations()) {
                if (operation.getOperationID() == id) {
                    continue;
                } else {
                    Date operationDateDebut = operation.getDateDebut();
                    Date operationDateFin = operation.getDateFin();
                    Date newDateDebut = newOperation.getDateDebut();
                    Date newDateFin = newOperation.getDateFin();

                    if (
                        // new operation date between operationDATDEB and DATFIN
                            (newDateDebut.compareTo(operationDateDebut) >= 0 && newDateDebut.compareTo(operationDateFin) <= 0 && operationDateFin.compareTo(newDateFin) >= 0 && newDateFin.compareTo(operationDateDebut) >= 0)
                                    // newDateDebut between operationDATDEB and operationDATFIN AND newDateFin after operationDATDEB and after operationDATFIN
                                    || (newDateDebut.compareTo(operationDateDebut) >= 0 && newDateDebut.compareTo(operationDateFin) <= 0 && /*newDateFin.compareTo(operationDateDebut) >= 0 &&*/ newDateFin.compareTo(operationDateFin) <= 0)
                                    // newDateDebut before operationDATDEB and before operationDATFIN AND
                                    || (newDateDebut.compareTo(operationDateDebut) <= 0 && newDateDebut.compareTo(operationDateFin) <= 0 && /*newDateFin.compareTo(operationDateDebut) >= 0 &&*/ newDateFin.compareTo(operationDateDebut) >= 0)
                                    // newDateDebut between operationDATDEB and operationDATFIN AND newDateFin after operationDATFIN
                                    || (newDateDebut.compareTo(operationDateDebut) >= 0 && newDateDebut.compareTo(operationDateFin) <= 0 && newDateFin.compareTo(operationDateFin) >= 0)

                    ) {
                        listCar.remove(operation.getCar());
                    }
                }
            }
        }

        if (listCar.isEmpty()) {
            operationServiceImpl.deleteOperationById(id);
            model.addAttribute("condition", "stepOne");
            OPERATION_ERROR = "Aucune voiture n'est diponible dans cette date";
            return "redirect:/operation/new";
        } else {
            model.addAttribute("operationID", id);
            model.addAttribute("condition", "stepTwo");
            model.addAttribute("listCars", listCar);
            return "operation/addOperation";
        }
    }

    @PostMapping("/operation/{id}/car/{idCar}")
    public String addCarIntoOperation(@PathVariable Long id, @PathVariable Long idCar) {
        Operation operation = operationServiceImpl.getOperationById(id);
        operation.setCar(carServiceImpl.getCarById(idCar));
        operationServiceImpl.saveOperation(operation);

        Car car;
        car = carServiceImpl.getCarById(idCar);
        car.setEtat("Non Disponible");

        carServiceImpl.saveCar(car);
        return "redirect:/operation/" + operation.getOperationID();
    }

    @GetMapping("/operation/{id}")
    public String showOperation(@PathVariable Long id, Model model) {
        model.addAttribute("operation", operationServiceImpl.getOperationById(id));
        return "operation/showOperation";
    }

    @GetMapping("/operation/all")
    public String showAllOperations(Model model) {
        model.addAttribute("operations", operationServiceImpl.getAllOperations());
        return "operation/listOperations";
    }

    @GetMapping("/operation/{id}/update")
    public String showUpdateOperation(@PathVariable Long id, Model model) {
        if (id > 0) {
            for (Operation operation : operationServiceImpl.getAllOperations()) {
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
        for (Operation operation : operationServiceImpl.getAllOperations()) {
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

                operationServiceImpl.saveOperation(operation);
                return "redirect:/operation/" + operation.getOperationID();
            }
        }
        return "redirect:/operation/all";
    }

    @GetMapping("/operation/{id}/delete")
    public String deleteOperation(@PathVariable Long id) {
        operationServiceImpl.deleteOperationById(id);
        return "redirect:/operation/all";
    }
}
