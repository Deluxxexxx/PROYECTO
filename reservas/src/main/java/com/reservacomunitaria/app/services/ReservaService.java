package com.reservacomunitaria.app.services;

import com.reservacomunitaria.app.models.Place;
import com.reservacomunitaria.app.models.Reserve;
import com.reservacomunitaria.app.models.User;
import com.reservacomunitaria.app.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
