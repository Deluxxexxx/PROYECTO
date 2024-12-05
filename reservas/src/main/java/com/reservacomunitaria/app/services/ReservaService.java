package com.reservacomunitaria.app.services;

import com.reservacomunitaria.app.models.Place;
import com.reservacomunitaria.app.models.Reserve;
import com.reservacomunitaria.app.models.User;
import com.reservacomunitaria.app.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservacomunitaria.app.Logger;

import java.util.List;
/*
@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserve> obtenerReservas() {
        return reservaRepository.findAll();
    }

    public Reserve guardarReserva(Reserve reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserve actualizarReserva(Reserve reserva) {
        return reservaRepository.save(reserva);
    }

    public void eliminarReserva(long id) {
        reservaRepository.deleteById(id);
    }

    public Reserve getReserveById(long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public List<Reserve> getReservesByUserId(long userId) {
        return reservaRepository.findByUserId(userId);
    }*/
@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private Logger logger;

    public List<Reserve> obtenerReservas() {
        try {
            List<Reserve> reservas = reservaRepository.findAll();
            logger.log("ObtenerReservas", "Exitoso");
            return reservas;
        } catch (Exception e) {
            logger.log("ObtenerReservas", "Error: " + e.getMessage());
            return null;
        }
    }

    public Reserve guardarReserva(Reserve reserva) {
        try {
            Reserve reservaGuardada = reservaRepository.save(reserva);
            logger.log("GuardarReserva", "Exitoso");
            return reservaGuardada;
        } catch (Exception e) {
            logger.log("GuardarReserva", "Error: " + e.getMessage());
            return null;
        }
    }

    public Reserve actualizarReserva(Reserve reserva) {
        try {
            Reserve reservaActualizada = reservaRepository.save(reserva);
            logger.log("ActualizarReserva", "Exitoso");
            return reservaActualizada;
        } catch (Exception e) {
            logger.log("ActualizarReserva", "Error: " + e.getMessage());
            return null;
        }
    }

    public void eliminarReserva(long id) {
        try {
            reservaRepository.deleteById(id);
            logger.log("EliminarReserva", "Exitoso");
        } catch (Exception e) {
            logger.log("EliminarReserva", "Error: " + e.getMessage());
        }
    }

    public Reserve getReserveById(long id) {
        try {
            Reserve reserva = reservaRepository.findById(id).orElse(null);
            logger.log("GetReservaById", "Exitoso");
            return reserva;
        } catch (Exception e) {
            logger.log("GetReservaById", "Error: " + e.getMessage());
            return null;
        }
    }

    public List<Reserve> getReservesByUserId(long userId) {
        try {
            List<Reserve> reservas = reservaRepository.findByUserId(userId);
            logger.log("GetReservasByUserId", "Exitoso");
            return reservas;
        } catch (Exception e) {
            logger.log("GetReservasByUserId", "Error: " + e.getMessage());
            return null;
        }
    }
}
