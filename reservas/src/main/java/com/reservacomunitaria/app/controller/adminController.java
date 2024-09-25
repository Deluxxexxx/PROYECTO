package com.reservacomunitaria.app.controller;

import com.reservacomunitaria.app.models.place;
import com.reservacomunitaria.app.services.placeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class adminController {

    @Autowired
    private placeService placeService;

    @PostMapping("/addPlace")
    public String addPlace(@ModelAttribute place newPlace) {
        placeService.insertPlace(newPlace);
        return "admin";
    }
}

