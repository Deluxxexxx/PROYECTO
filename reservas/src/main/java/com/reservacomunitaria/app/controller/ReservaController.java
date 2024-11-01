package com.reservacomunitaria.app.controller;

import com.reservacomunitaria.app.commands.ActualizarReservaCommand;
import com.reservacomunitaria.app.commands.CrearReservaCommand;
import com.reservacomunitaria.app.commands.EliminarReservaCommand;
import com.reservacomunitaria.app.models.Place;
import com.reservacomunitaria.app.models.Reserve;
import com.reservacomunitaria.app.models.User;
import com.reservacomunitaria.app.services.ReservaService;
import com.reservacomunitaria.app.services.placeService;
import com.reservacomunitaria.app.services.userService;
import com.reservacomunitaria.app.services.placeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private placeService PlaceService;

    @Autowired
    private userService UserService;


    @GetMapping("/mis-reservas")
    public String obtenerMisReservas(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }

        User usuario = UserService.getUserByEmail(principal.getName());
        List<Reserve> reservas = reservaService.getReservesByUserId(usuario.getId());
        model.addAttribute("reservas", reservas);
        return "userReserves";
    }

    @GetMapping("/mostrar")
    public String mostrarFormularioCreacion(@RequestParam long placeId, Model model, HttpSession session) {
        Reserve newReserve = new Reserve();
        newReserve.setPlace(PlaceService.getPlaceById(placeId));

        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            newReserve.setUser(loggedInUser);
        }

        model.addAttribute("reserva", newReserve);
        return "reservePlace";
    }

    @PostMapping("/crear")
    public String crearReserva(@ModelAttribute Reserve reserva, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            reserva.setUser(loggedInUser);
            reservaService.guardarReserva(reserva);
            return "userReserves";
        }

        return "loginScreen";
    }

    @GetMapping("/lista")
    public String listaReservas(Model model) {
        List<Reserve> reservas = reservaService.obtenerReservas();
        model.addAttribute("reservas", reservas);
        return "listaReservas";
    }

    @PostMapping("/eliminar")
    public String eliminarReserva(@RequestParam long id) {
        EliminarReservaCommand command = new EliminarReservaCommand(reservaService, id);
        command.execute();
        return "redirect:/reserva/lista";
    }

    @GetMapping("/editar")
    public String mostrarFormularioEdicion(@RequestParam long id, Model model) {
        Reserve reserva = reservaService.getReserveById(id);
        model.addAttribute("reserva", reserva);
        return "editarReserva";
    }

    @PostMapping("/editar")
    public String editarReserva(@RequestParam long id,
                                @RequestParam LocalDate fecha,
                                @RequestParam String hora) {
        Reserve existingReserve = reservaService.getReserveById(id);
        existingReserve.setFecha(fecha);
        existingReserve.setHora(hora);
        ActualizarReservaCommand command = new ActualizarReservaCommand(reservaService, existingReserve);
        command.execute();
        return "redirect:/reserva/lista";
    }
}