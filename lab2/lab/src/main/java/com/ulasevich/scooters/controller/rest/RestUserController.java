//package com.ulasevich.scooters.controller.rest;
//
//import com.ulasevich.scooters.Service.UserService;
//import com.ulasevich.scooters.domain.Role;
//import com.ulasevich.scooters.domain.User;
//import com.ulasevich.scooters.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/user")
//public class RestUserController {
//    @Autowired
//    public UserService userService;
//
//    @Autowired
//    private UserRepo userRepo;

//    @PreAuthorize("hasAuthority('ADMIN')")
//    @GetMapping
//    public String userList(Model model){
//        model.addAttribute("users", userService.findAll());
//        return "userlist";
//    }

//    @PreAuthorize("hasAuthority('ADMIN')")
//    @GetMapping("/{user}")
//    public String userEditForm(@PathVariable User user, Model model){
//        model.addAttribute("user", user);
//        model.addAttribute("role", Role.values());
//        return "userEdit";
//    }

//    @PostMapping
//    public String userSave(
//            @RequestBody User user){
//
//        return userRepo.save(user);;
//    }
//
//    @GetMapping("/profile")
//    public String getProfile(Model model, @AuthenticationPrincipal User user){
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("email", user.getEmail());
//
//        return "profile";
//    }
//
//    @PostMapping("/profile")
//    public String updateUser(@AuthenticationPrincipal User user, @RequestParam String password, @RequestParam String email){
//        userService.updateProfile(user, password, email);
//        return "redirect:/user/profile";
//    }
//}
