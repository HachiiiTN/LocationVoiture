package com.tekup.mp.web.controllers;

import com.tekup.mp.dao.GLOBAL.AppRepo;
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
        model.addAttribute("role", String.valueOf(AppRepo.getUserRole()));
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
        model.addAttribute("role", String.valueOf(AppRepo.getUserRole()));
        return "user/listUsers";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("role", String.valueOf(AppRepo.getUserRole()));
        return "user/showUser";
    }

    @GetMapping("/{id}/update")
    public String showUpdateUser(@PathVariable Long id, Model model) {
        model.addAttribute("role", String.valueOf(AppRepo.getUserRole()));
        if (id > 0) {
            for (User user : userService.getAllUsers()) {
                if (user.getIdUser() == id) {
                    UserForm userForm = new UserForm();
                    userForm.setIdUser(user.getIdUser());
                    userForm.setUsername(user.getUsername());
                    userForm.setFirstname(user.getFirstname());
                    userForm.setLastname(user.getLastname());
                    userForm.setRoles(user.getRoles());
                    userForm.setPassword(user.getPassword());
                    model.addAttribute("userForm", userForm);

                    return "user/updateUser";
                }
            }
        }
        return "redirect:/user/all";
    }

    @PostMapping("/{id}/update")
    public String updateUser(@PathVariable Long id, @Valid @ModelAttribute("userForm") UserForm userForm) {
        for (User user : userService.getAllUsers()) {
            if (user.getIdUser() == id) {

                user.setIdUser(userForm.getIdUser());
                user.setUsername(userForm.getUsername());
                user.setFirstname(userForm.getFirstname());
                user.setLastname(userForm.getLastname());
                user.setRoles(userForm.getRoles());
                user.setPassword(userForm.getPassword());

                userService.saveUser(user);
                return "redirect:/user/" + user.getIdUser();
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
