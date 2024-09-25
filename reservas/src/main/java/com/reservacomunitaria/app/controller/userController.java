package com.reservacomunitaria.app.controller;

import com.reservacomunitaria.app.models.admin;
import com.reservacomunitaria.app.models.place;
import com.reservacomunitaria.app.models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.reservacomunitaria.app.services.userService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.reservacomunitaria.app.services.placeService;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class userController {

    @Autowired
    private userService userService;

    @Autowired
    private placeService placeService;

    @PostMapping("/loginScreen")
    public String login(){
        return "loginScreen";
    }

    /*@PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model){
        user loggedInUser = userService.getUserByEmailAndPassword(email, password);

        if(loggedInUser != null){
            List<place> places = placeService.getAllPlaces();
            model.addAttribute("places", places);

            if (loggedInUser.getRole() == user.Role.ADMIN){
                return "redirect:/admin";
            }
            else{
                return "homepage";
            }
        }
        return "loginScreen";
    }*/

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        user loggedInUser = userService.getUserByEmailAndPassword(email, password);
        admin loggedInAdmin = userService.getAdminByEmailAndPassword(email, password);

        if (loggedInUser != null) {
            List<place> places = placeService.getAllPlaces();
            model.addAttribute("places", places);
            return "homepage";
        } else if (loggedInAdmin != null) {
            List<place> places = placeService.getAllPlaces();
            model.addAttribute("places", places);
            return "admin";
        }

        return "loginScreen";
    }


    @PostMapping("/register")
    public String register(@RequestParam String email, @RequestParam String password, @RequestParam String username){
        userService.registerUser(new user(username, email, password));
        return "loginScreen";
    }

    @PostMapping("/registerField")
    public String registerField(){
        return "registerScreen";
    }
}
