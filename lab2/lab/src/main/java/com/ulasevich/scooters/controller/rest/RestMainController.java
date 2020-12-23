//package com.ulasevich.scooters.controller.rest;
//
//import com.ulasevich.scooters.domain.Scooters;
//import com.ulasevich.scooters.repository.ScootersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//public class RestMainController {
//
//    @Autowired
//    private ScootersRepository scootersRepository;
//
//    @GetMapping("/api/about")
//    public String about(@RequestParam(name="name", required = false, defaultValue = "World") String name,
//                        Map<String, Object> model){
//        model.put("name", name);
//        return "about";
//    }
//
//    @GetMapping("/api/")
//    public String scooters(Map<String, Object> model){
//        return "scooters";
//    }
//
//    @GetMapping("/index")
//    public String index(@RequestParam(required = false, defaultValue = "") String location, Model model){
//        Iterable<Scooters> scooters = scootersRepository.findAll();
//
//        if (location != ""){
//            scooters = scootersRepository.findByLocation(location);
//        } else {
//            scooters = scootersRepository.findAll();
//        }
//
//        model.addAttribute("scooters", scooters);
//        return "index";
//    }
//
//    @PostMapping("/api/add-scooter")
//    public String addScooter(@RequestParam String location,
//                             @RequestParam Boolean flag,
//                             @RequestParam String producer,
//                             @RequestParam String brand,
//                             @RequestParam Integer charge_level,
//                             Map<String, Object> model){
//
//        Scooters scooter = new Scooters(location, flag, producer, brand, charge_level);
//        scootersRepository.save(scooter);
//
//        Iterable<Scooters> scooters = scootersRepository.findAll();
//        model.put("scooters", scooters);
//
//        return "index";
//    }
//}
