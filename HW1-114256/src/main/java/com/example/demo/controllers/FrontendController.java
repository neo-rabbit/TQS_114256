package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.FoodFacility;
import com.example.demo.services.BookingService;

@Controller
@RequestMapping("/frontend")
public class FrontendController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public String loadIndex(Model model){
        model.addAttribute("facilities", bookingService.findAllFacilities());
        return "index";
    }

    @GetMapping("/{id}")
    public String loadMenus(@PathVariable("id") Long id ,Model model){
        FoodFacility facility = bookingService.findFacility(id);
        model.addAttribute("facility", facility);
        model.addAttribute("meals", bookingService.findMealsFromFacility(facility));
        return "menus";
    }
}
