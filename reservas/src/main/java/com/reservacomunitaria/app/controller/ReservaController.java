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

    @GetMapping("/reservas")
    public String obtenerReservas(Model model) {
        List<Reserve> reservas = reservaService.obtenerReservas();
        model.addAttribute("reservas", reservas);
        return "userReserves";
    }

    @PostMapping("/mostrar")
    public String mostrarFormularioCreacion(@RequestParam long placeId , Model model) {
        Reserve newReserve = new Reserve();
        newReserve.setPlace(PlaceService.getPlaceById(placeId));
        model.addAttribute("reserva", newReserve);
        return "reservePlace";
    }

    @PostMapping("/crear")
    public String crearReserva(@ModelAttribute Reserve reserva, Principal principal) {
        String username = principal.getName();
        User user = UserService.findByUsername(username);

        if (user != null) {
            reserva.setUser(user);
            CrearReservaCommand command = new CrearReservaCommand(reservaService, reserva);
            command.execute();
            return "redirect:/reserva/lista";
        } else {
            return "error";
        }
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