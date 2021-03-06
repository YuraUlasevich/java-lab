package com.ulasevich.scooters.controller.view;

import com.ulasevich.scooters.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    @Autowired
    UserRepo userRepo;

    @GetMapping
    public String adminPage(Model model){
        return "adminpage";
    }
}
