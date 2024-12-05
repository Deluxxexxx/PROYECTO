package com.reservacomunitaria.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.reservacomunitaria.app.services.placeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @Autowired
    private placeService placeService;

    @GetMapping("/homepage")
    public String homepage(Model model) {
        model.addAttribute("places", placeService.getAllPlaces());
        return "homepage";
    }
}

