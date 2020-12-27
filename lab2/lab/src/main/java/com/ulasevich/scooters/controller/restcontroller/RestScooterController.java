package com.ulasevich.scooters.controller.restcontroller;

import com.ulasevich.scooters.domain.Scooters;
import com.ulasevich.scooters.model.Scooter;
import com.ulasevich.scooters.repository.ScootersRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class RestScooterController {

    @Autowired
    ScootersRepository scooterRepo;


    @GetMapping(value = "scooters", produces = "application/json")
    public @ResponseBody List<Scooter> getScooters(){
        List<Scooters> scootersList =  scooterRepo.findAll();
        List<Scooter> scooterList = new ArrayList<>();
        for (Scooters sc:scootersList) {
            scooterList.add(new Scooter(sc.getLocation(), sc.getProducer(), sc.getBrand(), sc.getChargeLevel()));
        }
        return scooterList;
    }

    @PostMapping(value = "scooters", consumes = "application/json")
    public void createScooter(@RequestBody Scooter sc){
        Scooters scooter = new Scooters(sc.getLocation(), sc.getProducer(), sc.getBrand(), sc.getCharge_level());
        scooterRepo.save(scooter);
    }

    @PutMapping(value = "scooters", consumes = "application/json")
    public void changeScooter(@RequestBody Scooters sc){
        Scooters scooter = new Scooters();
        if(scooterRepo.existsById(sc.getId())){
            scooter = scooterRepo.findById(sc.getId()).orElse(null);
        }
        if (sc.getLocation() != null && !scooter.getLocation().equals(sc.getLocation()))
            scooter.setLocation(sc.getLocation());
        if (sc.getProducer() != null && !scooter.getProducer().equals(sc.getProducer()))
            scooter.setProducer(sc.getProducer());
        if (sc.getBrand() != null && !scooter.getBrand().equals(sc.getBrand()))
            scooter.setBrand(sc.getBrand());
        if (sc.getCharge_level() != null && !scooter.getCharge_level().equals(sc.getCharge_level()))
            scooter.setCharge_level(sc.getChargeLevel());
        scooterRepo.save(scooter);
    }

    @DeleteMapping("/scooters/{id}")
    public void deleteScooter(@PathVariable Long id){
        if(scooterRepo.existsById(id)){
            scooterRepo.deleteById(id);
        }
    }
}
