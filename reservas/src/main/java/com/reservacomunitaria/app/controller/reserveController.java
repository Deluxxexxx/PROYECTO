package com.reservacomunitaria.app.controller;

import com.reservacomunitaria.app.models.place;
import com.reservacomunitaria.app.models.reserve;
import com.reservacomunitaria.app.models.user;
import com.reservacomunitaria.app.services.reserveService;
import com.reservacomunitaria.app.services.placeService;
import com.reservacomunitaria.app.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class reserveController {

    @Autowired
    private reserveService reserveService;

    @Autowired
    private placeService placeService;

    @Autowired
    private userService userService;

    @GetMapping("/user/reserves")
    public String viewReserves(Model model, @RequestParam("userId") long userId) {
        List<reserve> reserves = reserveService.getReservesByUserId(userId);
        model.addAttribute("reserves", reserves);
        return "userReserves";
    }

    @PostMapping("/user/reservePlace")
    public String reservePlace(@RequestParam("userId") long userId,
                               @RequestParam("placeId") long placeId,
                               @RequestParam("fecha") String fecha,
                               @RequestParam("hora") String hora) {
        user user = userService.getUserById(userId);
        place place = placeService.getPlaceById(placeId);
        reserve newReserve = new reserve(LocalDate.parse(fecha), hora, user, place);
        reserveService.createReserve(newReserve);
        return "redirect:/user/reserves?userId=" + userId;
    }

    @PostMapping("/user/updateReserve")
    public String updateReserve(@RequestParam("reserveId") long reserveId,
                                @RequestParam("fecha") String fecha,
                                @RequestParam("hora") String hora) {
        reserve existingReserve = reserveService.getReserveById(reserveId);
        existingReserve.setFecha(LocalDate.parse(fecha));
        existingReserve.setHora(hora);
        reserveService.updateReserve(existingReserve);
        return "redirect:/user/reserves?userId=" + existingReserve.getUser().getId();
    }

    @PostMapping("/user/deleteReserve")
    public String deleteReserve(@RequestParam("reserveId") long reserveId,
                                @RequestParam("userId") long userId) {
        reserveService.deleteReserve(reserveId);
        return "redirect:/user/reserves?userId=" + userId;
    }
}


