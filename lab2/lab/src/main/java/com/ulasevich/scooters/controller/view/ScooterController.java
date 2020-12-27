package com.ulasevich.scooters.controller.view;

import com.ulasevich.scooters.domain.Scooters;
import com.ulasevich.scooters.repository.ScootersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
@RequestMapping("/scooterwork")
@PreAuthorize("hasAuthority('ADMIN')")
public class ScooterController {
    @Autowired
    ScootersRepository scooterRepo;
    @GetMapping
    public String userList(Model model){
        model.addAttribute("scooters", scooterRepo.findAll());
        return "scooterwork";
    }

    @PostMapping
    public String addScooter(@RequestParam String location,
                             @RequestParam String producer,
                             @RequestParam String brand,
                             @RequestParam Integer charge_level,
                             Map<String, Object> model){

        Scooters scooter = new Scooters(location, producer, brand, charge_level);
        scooterRepo.save(scooter);

        Iterable<Scooters> scooters = scooterRepo.findAll();
        model.put("scooters", scooters);

        return "scooterwork";
    }
}
