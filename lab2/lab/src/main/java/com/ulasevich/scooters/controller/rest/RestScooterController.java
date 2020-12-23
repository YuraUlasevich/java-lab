//package com.ulasevich.scooters.controller.rest;
//
//import com.ulasevich.scooters.domain.Scooters;
//import com.ulasevich.scooters.repository.ScootersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/scooterwork")
//@PreAuthorize("hasAuthority('ADMIN')")
//public class RestScooterController {
//    @Autowired
//    ScootersRepository scooterRepo;
//    @GetMapping
//    public String userList(Model model){
//        model.addAttribute("scooters", scooterRepo.findAll());
//        return "scooterwork";
//    }
//
//    @PostMapping
//    public String addScooter(@RequestParam String location,
//                             @RequestParam Boolean flag,
//                             @RequestParam String producer,
//                             @RequestParam String brand,
//                             @RequestParam Integer charge_level,
//                             Map<String, Object> model){
//
//        Scooters scooter = new Scooters(location, flag, producer, brand, charge_level);
//        scooterRepo.save(scooter);
//
//        Iterable<Scooters> scooters = scooterRepo.findAll();
//        model.put("scooters", scooters);
//
//        return "scooterwork";
//    }
//}
