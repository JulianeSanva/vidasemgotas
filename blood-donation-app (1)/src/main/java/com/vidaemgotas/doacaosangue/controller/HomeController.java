package com.vidaemgotas.doacaosangue.controller;

import com.vidaemgotas.doacaosangue.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final LocationService locationService;

    @Autowired
    public HomeController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("locations", locationService.getAllLocations());
        return "index";
    }
}

