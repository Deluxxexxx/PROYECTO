package com.reservacomunitaria.app.commands;

import com.reservacomunitaria.app.models.Reserve;
import com.reservacomunitaria.app.services.ReservaService;

public class ActualizarReservaCommand implements ReservaCommand {
    private final ReservaService reservaService;
    private final Reserve reserva;

    public ActualizarReservaCommand(ReservaService reservaService, Reserve reserva) {
        this.reservaService = reservaService;
        this.reserva = reserva;
    }

    @Override
    public void execute() {
        reservaService.actualizarReserva(reserva);
    }
}

