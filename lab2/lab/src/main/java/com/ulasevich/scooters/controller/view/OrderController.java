package com.ulasevich.scooters.controller.view;

import com.ulasevich.scooters.Service.ScooterService;
import com.ulasevich.scooters.domain.Order;
import com.ulasevich.scooters.domain.Role;
import com.ulasevich.scooters.domain.Scooters;
import com.ulasevich.scooters.domain.User;
import com.ulasevich.scooters.repository.OrderRepo;
import com.ulasevich.scooters.repository.ScootersRepository;
import com.ulasevich.scooters.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ScootersRepository scootersRepository;

    @Autowired
    private ScooterService scooterService;

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String showMyOrders(Map<String, List> model,@AuthenticationPrincipal User user){
        List<Order> orderList = orderRepo.findByUser_id(user.getId());
        List<Scooters> scootersList = new ArrayList<>();
        for (Order order: orderList) {
            scootersList.add(order.getScooter());
        }
        model.put("scooters", scootersList);
        return "orders";
    }

    @PostMapping("{scooterId}")
    public String createOrder(@PathVariable Long scooterId, @AuthenticationPrincipal User user){

        Scooters scooter = new Scooters();
        if(scootersRepository.existsById(scooterId)){
            scooter = scootersRepository.findById(scooterId).orElse(null);
        }
        if (scooter.getFlag() != null || scooter.getFlag() !=  "Ordered"){
            User user1 = userRepo.findByUsername(user.getUsername());
            scooter.setFlag("Ordered");

            Order order = new Order();
            order.setScooter(scooter);
            order.setUser(user1);

            scootersRepository.save(scooter);
            orderRepo.save(order);
        }


        return "redirect:/order";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("admin")
    public String orderAdminPage(Map<String, List> model){
        List<Order> orderList = orderRepo.findAll();
        List<Scooters> scootersList = new ArrayList<>();
        for (Order order: orderList) {
            scootersList.add(order.getScooter());
        }
        model.put("scooters", scootersList);
        return "ordersAdmin";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin/{scooterId}")
    public String userEditForm(@PathVariable Long scooterId, Model model){
        Scooters scooter = new Scooters();
        if(scootersRepository.existsById(scooterId)){
            scooter = scootersRepository.findById(scooterId).orElse(null);
        }
        model.addAttribute("scooter", scooter);
        return "orderEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/admin/{scooterId}")
    public String orderEditForm(@RequestParam String location,
                                @RequestParam String flag,
                                @RequestParam Integer charge_level,
                                @PathVariable Long scooterId){
        Scooters scooter = new Scooters();
        if(scootersRepository.existsById(scooterId)){
            scooter = scootersRepository.findById(scooterId).orElse(null);
        }
        scooterService.saveScooter(location, flag, charge_level, scooter);

        return "redirect:/index";
    }

}
