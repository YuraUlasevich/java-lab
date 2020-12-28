package com.ulasevich.scooters.controller.view;

import com.ulasevich.scooters.Service.ScooterService;
import com.ulasevich.scooters.domain.Order;
import com.ulasevich.scooters.domain.Scooters;
import com.ulasevich.scooters.domain.User;
import com.ulasevich.scooters.repository.OrderRepo;
import com.ulasevich.scooters.repository.ScootersRepository;
import com.ulasevich.scooters.repository.UserRepo;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



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

        boolean flag = orderRepo.existsByScooterIdAndStatus(scooterId, "Ordered");
        if (!flag){
            User user1 = userRepo.findByUsername(user.getUsername());
            Order order = new Order();
            order.setScooter(scooter);
            order.setUser(user1);
            order.setStatus("Ordered");
            order.setCost(0);
            scootersRepository.save(scooter);
            orderRepo.save(order);
        }
        return "redirect:/order";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("admin")
    public String orderAdminPage(Map<String, List> model){
        List<Order> orderList = orderRepo.findAll();
        model.put("orders", orderList);
        return "ordersAdmin";
    }
//ToDo: Переделать
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin/{orderId}")
    public String orderEditForm(@PathVariable Long orderId, Model model){
        Order order = new Order();
        if(orderRepo.existsById(orderId)){
            order = orderRepo.findById(orderId).orElse(null);
        }
        model.addAttribute("order", order);
        return "orderEdit";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/admin/{orderId}")
    public String orderEditForm(@RequestParam Integer cost,
                                @RequestParam String status,
                                @PathVariable Long orderId){
        Order order = new Order();
        if(orderRepo.existsById(orderId)){
            order = orderRepo.findById(orderId).orElse(null);
        }
        order.setCost(cost);
        order.setStatus(status);
        orderRepo.save(order);
        return "redirect:/index";
    }

}
