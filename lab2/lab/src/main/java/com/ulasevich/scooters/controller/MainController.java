package com.ulasevich.scooters.controller;

import com.ulasevich.scooters.domain.Scooters;
import com.ulasevich.scooters.repository.ScootersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ScootersRepository scootersRepository;

    @GetMapping("/about")
    public String about(@RequestParam(name="name", required = false, defaultValue = "World") String name,
                        Map<String, Object> model){
        model.put("name", name);
        return "about";
    }

    @GetMapping("/")
    public String scooters(Map<String, Object> model){
        return "scooters";
    }

    @GetMapping("/index")
    public String index(Map<String, Object> model){
        Iterable<Scooters> scooters = scootersRepository.findAll();
        model.put("scooters", scooters);
        return "index";
    }

    @PostMapping("/index")
    public String addScooter(@RequestParam String location,
                             @RequestParam Boolean flag,
                             @RequestParam String producer,
                             @RequestParam String brand,
                             @RequestParam Integer charge_level,
                             Map<String, Object> model){

        Scooters scooter = new Scooters(location, flag, producer, brand, charge_level);
        scootersRepository.save(scooter);

        Iterable<Scooters> scooters = scootersRepository.findAll();
        model.put("scooters", scooters);

        return "index";
    }

    @PostMapping("/filter")
    public String findScooter(@RequestParam String location,
                              Map<String, Object> model){
        Iterable<Scooters> scooters;
        if (location != null){
            scooters = scootersRepository.findByLocation(location);
        } else {
            scooters = scootersRepository.findAll();
        }

        model.put("scooters", scooters);
        return "index";
    }
}
