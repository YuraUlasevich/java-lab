package com.example.demo.controller;

import com.example.demo.forms.RealtyForm;
import com.example.demo.model.Realty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class RealtyController {
    public static List<Realty> realtyList = new ArrayList<>();

    static{
        realtyList.add(new Realty("Kalvoriyskaya", 1));
        realtyList.add(new Realty("Kalvoriyskaya", 2));
    }

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        model.addAttribute("message", message);
        return modelAndView;
    }

    @RequestMapping(value = {"/allrealty"}, method = RequestMethod.GET)
    public  ModelAndView allRealty(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("realtylist");
        model.addAttribute("realtyList", realtyList);
        return modelAndView;
    }

    @RequestMapping(value = {"/addhouse"}, method = RequestMethod.GET)
    public ModelAndView showAddHousePage(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addhouse");
        RealtyForm realtyForm = new RealtyForm();
        model.addAttribute("realtyform", realtyForm);
        return modelAndView;
    }

    @RequestMapping(value = {"/addhouse"}, method = RequestMethod.POST)
    public ModelAndView saveHouse(Model model,
                                   @ModelAttribute("realtyform") RealtyForm realtyForm) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("realtylist");
        String street = realtyForm.getStreet();
        Integer houseNumber = realtyForm.getHouseNumber();
        if (street != null && street.length() > 0 //
                && houseNumber != null && houseNumber > 0) {
            Realty newRealty = new Realty(street, houseNumber);
            realtyList.add(newRealty);
            model.addAttribute("realtyList",realtyList);
            return modelAndView;
        }
        model.addAttribute("errorMessage", errorMessage);
//        modelAndView.setViewName("addhouse");
        return modelAndView;
    }

    @RequestMapping(value = {"/delhouse"}, method = RequestMethod.DELETE)
    public ModelAndView delHouse(Model model,
                                   @ModelAttribute("realtyform") RealtyForm realtyForm) {
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("realtylist");
        String street = realtyForm.getStreet();
        Integer houseNumber = realtyForm.getHouseNumber();
        Iterator<Realty> realtyIterator = realtyList.iterator();
        while (realtyIterator.hasNext()){
            Realty re = realtyIterator.next();
            if(re.getStreet().equals(street) && re.getHouseNumber().equals(houseNumber)){
                realtyIterator.remove();
            }
        }
        model.addAttribute("errorMessage", errorMessage);
        modelAndView.setViewName("realtylist");
        return modelAndView;
    }

    @RequestMapping(value = {"/delhouse"}, method = RequestMethod.GET)
    public ModelAndView showDelHousePage(Model model) {
        ModelAndView modelAndView = new ModelAndView("delhouse");
        RealtyForm realtyForm = new RealtyForm();
        model.addAttribute("realtyform", realtyForm);
        return modelAndView;
    }
}
