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

import com.reservacomunitaria.app.Logger;
import java.io.File;
import java.util.Scanner;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private placeService PlaceService;

    @Autowired
    private userService UserService;

    @Autowired
    private Logger logger;

/*
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
            return "redirect:/homepage";
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
    }*/
@GetMapping("/mis-reservas")
public String obtenerMisReservas(Model model, Principal principal) {
    try {
        User usuario = UserService.getUserByEmail(principal.getName());
        List<Reserve> reservas = reservaService.getReservesByUserId(usuario.getId());
        model.addAttribute("reservas", reservas);
        Logger.log("ObtenerMisReservas", "Exitoso");
        return "userReserves";
    } catch (Exception e) {
        Logger.log("ObtenerMisReservas", "Error: " + e.getMessage());
        return "error";
    }
}

    @GetMapping("/mostrar")
    public String mostrarFormularioCreacion(@RequestParam long placeId, Model model, HttpSession session) {
        try {
            Reserve newReserve = new Reserve();
            newReserve.setPlace(PlaceService.getPlaceById(placeId));

            User loggedInUser = (User) session.getAttribute("loggedInUser");
            if (loggedInUser != null) {
                newReserve.setUser(loggedInUser);
            }

            model.addAttribute("reserva", newReserve);
            Logger.log("MostrarFormularioCreacion", "Exitoso");
            return "reservePlace";
        } catch (Exception e) {
            Logger.log("MostrarFormularioCreacion", "Error: " + e.getMessage());
            return "error";
        }
    }

    @PostMapping("/crear")
    public String crearReserva(@ModelAttribute Reserve reserva, HttpSession session) {
        try {
            User loggedInUser = (User) session.getAttribute("loggedInUser");
            if (loggedInUser != null) {
                reserva.setUser(loggedInUser);
                reservaService.guardarReserva(reserva);
                Logger.log("CrearReserva", "Exitoso");
                return "redirect:/homepage";
            }
        } catch (Exception e) {
            Logger.log("CrearReserva", "Error: " + e.getMessage());
        }
        return "loginScreen";
    }

    @GetMapping("/lista")
    public String listaReservas(Model model) {
        try {
            List<Reserve> reservas = reservaService.obtenerReservas();
            model.addAttribute("reservas", reservas);
            Logger.log("ListaReservas", "Exitoso");
            return "listaReservas";
        } catch (Exception e) {
            Logger.log("ListaReservas", "Error: " + e.getMessage());
            return "error";
        }
    }

    @PostMapping("/eliminar")
    public String eliminarReserva(@RequestParam long id) {
        try {
            EliminarReservaCommand command = new EliminarReservaCommand(reservaService, id);
            command.execute();
            Logger.log("EliminarReserva", "Exitoso");
            return "redirect:/reserva/lista";
        } catch (Exception e) {
            Logger.log("EliminarReserva", "Error: " + e.getMessage());
        }
        return "redirect:/reserva/lista";
    }

    @GetMapping("/editar")
    public String mostrarFormularioEdicion(@RequestParam long id, Model model) {
        try {
            Reserve reserva = reservaService.getReserveById(id);
            model.addAttribute("reserva", reserva);
            Logger.log("MostrarFormularioEdicion", "Exitoso");
            return "editarReserva";
        } catch (Exception e) {
            Logger.log("MostrarFormularioEdicion", "Error: " + e.getMessage());
            return "error";
        }
    }

    @PostMapping("/editar")
    public String editarReserva(@RequestParam long id,
                                @RequestParam LocalDate fecha,
                                @RequestParam String hora) {
        try {
            Reserve existingReserve = reservaService.getReserveById(id);
            existingReserve.setFecha(fecha);
            existingReserve.setHora(hora);
            ActualizarReservaCommand command = new ActualizarReservaCommand(reservaService, existingReserve);
            command.execute();
            Logger.log("EditarReserva", "Exitoso");
            return "redirect:/reserva/lista";
        } catch (Exception e) {
            Logger.log("EditarReserva", "Error: " + e.getMessage());
        }
        return "redirect:/reserva/lista";
    }

    @GetMapping("/ver-Logs")
    @ResponseBody
    public String verLogs(Model model, Principal principal) {
        try {
            User usuario = UserService.getUserByEmail(principal.getName());
            if (usuario.getRole().equals("ADMIN")) {
                model.addAttribute("logs", leerArchivoLogs());
                return "ver-Logs";
            } else {
                return "redirect:/";
            }
        } catch (Exception e) {
            Logger.log(principal.getName(), "ver-Logs", "Error: " + e.getMessage());
            return "error";
        }
    }

    private String leerArchivoLogs() {
        try {
            File archivo = new File("logs.txt");
            Scanner scanner = new Scanner(archivo);
            StringBuilder contenido = new StringBuilder();
            while (scanner.hasNextLine()) {
                contenido.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
            return contenido.toString();
        } catch (Exception e) {
            Logger.log("LeerArchivoLogs", "Error: " + e.getMessage());
            return "";
        }
    }
}