package com.ulasevich.scooters.controller.view;

import com.ulasevich.scooters.controller.ControllerUtils;
import com.ulasevich.scooters.domain.Scooters;
import com.ulasevich.scooters.repository.ScootersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.message.Message;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    public String index(@RequestParam(required = false, defaultValue = "") String location, Model model){
        Iterable<Scooters> scooters = scootersRepository.findAll();

        if (location != ""){
            scooters = scootersRepository.findByLocation(location);
        } else {
            scooters = scootersRepository.findAll();
        }

        model.addAttribute("scooters", scooters);
        return "index";
    }

    @PostMapping("/index")
    public String addScooter(@RequestParam @Valid Scooters scooters,
                             BindingResult bindingResult,
                             Model model){
        if (bindingResult.hasErrors()){
            ControllerUtils controllerUtils = new ControllerUtils();
            Map<String, String> errorsMap = controllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("scooters", scooters);

        } else {
            Scooters scooter = new Scooters(scooters.getLocation(), scooters.getFlag(), scooters.getProducer(), scooters.getBrand(), scooters.getChargeLevel());
            scootersRepository.save(scooter);
        }


        Iterable<Scooters> scootersc = scootersRepository.findAll();
        model.addAttribute("scooters", scootersc);

        return "index";
    }
}
