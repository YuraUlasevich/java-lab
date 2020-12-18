package com.ulasevich.scooters.controller;


import com.ulasevich.scooters.domain.Role;
import com.ulasevich.scooters.domain.Users;
import com.ulasevich.scooters.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    UserRepo userRepo;

    @GetMapping
    public String adminPage(Model model){
        return "adminpage";
    }
}
