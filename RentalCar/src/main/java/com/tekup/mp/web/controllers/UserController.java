package com.tekup.mp.web.controllers;

import com.tekup.mp.jpa.entities.User;
import com.tekup.mp.metier.servicesImpl.UserServiceImpl;
import com.tekup.mp.web.model.requests.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute(new User());
        return "user/addUser";
    }

    @PostMapping("/new")
    public String saveUserController(User user) {
        userService.saveUser(user);
        return "redirect:/user/" + user.getIdUser();
    }

    @GetMapping("/all")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/listUsers";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/showUser";
    }

    @GetMapping("/{id}/update")
    public String showUpdateUser(@PathVariable Long id, Model model) {
        if (id > 0) {
            for (User user : userService.getAllUsers()) {
                if (user.getIdUser() == id) {
                    /*CarForm carForm = new CarForm();
                    carForm.setCarID(car.getCarID());
                    carForm.setImmatriculation(car.getImmatriculation());
                    carForm.setMarque(car.getMarque());
                    carForm.setModele(car.getModele());
                    carForm.setDateMiseCirculation(car.getDateMiseCirculation());
                    carForm.setPrixLocation(car.getPrixLocation());
                    carForm.setEtat(car.getEtat());
                    model.addAttribute("carForm", carForm);

                     */
                    return "car/updateUser";
                }
            }
        }
        return "redirect:/user/all";
    }

    @PostMapping("/{id}/update")
    public String updateUser(@PathVariable Long id, @Valid @ModelAttribute("userForm") UserForm userForm) {
        for (User user : userService.getAllUsers()) {
            if (user.getIdUser() == id) {
                /*
                user.setCarID(carForm.getCarID());
                user.setImmatriculation(carForm.getImmatriculation());
                user.setMarque(carForm.getMarque());
                user.setModele(carForm.getModele());
                user.setDateMiseCirculation(carForm.getDateMiseCirculation());
                user.setPrixLocation(carForm.getPrixLocation());
                user.setEtat(carForm.getEtat());

                carService.saveCar(user);
                return "redirect:/user/" + user.getCarID();

                 */
            }
        }
        return "redirect:/user/all";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/user/all";
    }
}
