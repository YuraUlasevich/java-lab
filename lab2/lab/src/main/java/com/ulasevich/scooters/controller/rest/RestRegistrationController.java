//package com.ulasevich.scooters.controller.rest;
//
//import com.ulasevich.scooters.Service.UserService;
//import com.ulasevich.scooters.domain.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//
//@RestController
//public class RestRegistrationController {
//    @Autowired
//    private UserService userService;
//    @GetMapping("/api/registration")
//    public String registration(){
//        return "registration";
//    }
//
//    @PostMapping("/api/registration")
//    public String registerUser(User user, Map<String, Object> model){
//
//        if (!userService.addUser(user)){
//            model.put("message", "User exists");
//            return "registration";
//        }
//        return "redirect:/login";
//    }
//
//    @GetMapping("/api/activate/{code}")
//    public String activate(Model model, @PathVariable String code){
//        boolean isActivated =  userService.activateUser(code);
//
//        if (isActivated){
//            model.addAttribute("message", "User successfully activated!");
//        } else{
//            model.addAttribute("message", "Activation code is not found!");
//        }
//        return "login";
//    }
//}
