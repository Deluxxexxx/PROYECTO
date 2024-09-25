package com.reservacomunitaria.app.controller;

import com.reservacomunitaria.app.models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import com.reservacomunitaria.app.services.userService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/loginScreen")
    public String login(){
        return "loginScreen";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password){
        if(userService.getUserByEmailAndPassword(email, password) != null){
            return "homepage";
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
