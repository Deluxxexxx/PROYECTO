package com.reservacomunitaria.app.controller;

import com.reservacomunitaria.app.models.place;
import com.reservacomunitaria.app.services.placeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class adminController {

    @Autowired
    private placeService placeService;

    @PostMapping("/addPlace")
    public String addPlace(@ModelAttribute place newPlace, Model model) {
        placeService.insertPlace(newPlace);
        List<place> places = placeService.getAllPlaces();
        model.addAttribute("places", places);
        return "admin";
    }

    @PostMapping("/loadCreatePlace")
    public String loadCreatePlace(){
        return "adminCreatePlace";
    }

    @GetMapping("/adminDeletePlace")
    public String deletePlace(Model model){
        List<place> places = placeService.getAllPlaces();
        model.addAttribute("places", places);
        return "adminDeletePlace";
    }

    @PostMapping("/deletePlace")
    public String delete(@RequestParam long id) {
        placeService.deletePlace(id);
        return "admin";
    }

    @GetMapping("/adminEditPlace")
    public String editPlace(@RequestParam long id, Model model) {
        place placeToEdit = placeService.getPlaceById(id);
        model.addAttribute("place", placeToEdit);
        return "adminEditPlace";
    }

    @PostMapping("/updatePlace")
    public String updatePlace(@RequestParam long id,
                              @RequestParam String name,
                              @RequestParam String description,
                              @RequestParam int capacity,
                              @RequestParam String address,
                              @RequestParam boolean available, Model model) {
        place updatedPlace = new place(name, description, capacity, address, available);
        updatedPlace.setId(id);
        placeService.updatePlace(updatedPlace);

        List<place> places = placeService.getAllPlaces();
        model.addAttribute("places", places);

        return "admin";
    }
}


