package com.reservacomunitaria.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.reservacomunitaria.app.services.userService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/logscreen")
    public String login(){
        return "logscreen";
    }
}
