package com.reservacomunitaria.app.controller;

import com.reservacomunitaria.app.models.admin;
import com.reservacomunitaria.app.models.Place;
import com.reservacomunitaria.app.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.reservacomunitaria.app.services.userService;
import org.springframework.web.bind.annotation.*;
import com.reservacomunitaria.app.services.placeService;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping
@SessionAttributes("loggedInUser")
public class userController {

    @Autowired
    private userService userService;

    @Autowired
    private placeService placeService;

    @PostMapping("/loginScreen")
    public String login(){
        return "loginScreen";
    }

    /*
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        User loggedInUser = userService.getUserByEmailAndPassword(email, password);
        admin loggedInAdmin = userService.getAdminByEmailAndPassword(email, password);

        if (loggedInUser != null) {
            List<Place> places = placeService.getAllPlaces();
            model.addAttribute("places", places);
            return "homepage";
        } else if (loggedInAdmin != null) {
            List<Place> places = placeService.getAllPlaces();
            model.addAttribute("places", places);
            return "admin";
        }

        return "loginScreen";
    }
    */

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        User loggedInUser = userService.getUserByEmailAndPassword(email, password);
        admin loggedInAdmin = userService.getAdminByEmailAndPassword(email, password);

        if (loggedInUser != null) {
            session.setAttribute("loggedInUser", loggedInUser);
            List<Place> places = placeService.getAllPlaces();
            model.addAttribute("places", places);
            return "homepage";
        } else if (loggedInAdmin != null) {
            session.setAttribute("loggedInAdmin", loggedInAdmin);
            List<Place> places = placeService.getAllPlaces();
            model.addAttribute("places", places);
            return "admin";
        }

        return "loginScreen";
    }

    @PostMapping("/register")
    public String register(@RequestParam String email, @RequestParam String password, @RequestParam String username){
        userService.registerUser(new User(username, email, password));
        return "loginScreen";
    }

    @PostMapping("/registerField")
    public String registerField(){
        return "registerScreen";
    }

    @GetMapping("/user/viewReservePlace")
    public String reservePlace(){
        return "createOrUpdateReserve";
    }

    @GetMapping("/user/viewReserves")
    public String reserves(){
        return "userReserves";
    }
}
