package com.ulasevich.scooters.controller;

import com.ulasevich.scooters.domain.Role;
import com.ulasevich.scooters.domain.Users;
import com.ulasevich.scooters.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;


@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(Users users, Map<String, Object> model){
        Users usersDB = userRepo.findByUsername(users.getUsername());
        if (usersDB != null){
            model.put("message", "User exists");
            return "registration";
        }

        users.setActive(true);
        users.setRole(Collections.singleton(Role.USER));
        userRepo.save(users);
        return "redirect:/login";
    }
}
