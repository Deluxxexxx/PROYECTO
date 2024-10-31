package com.reservacomunitaria.app.commands;

import com.reservacomunitaria.app.services.ReservaService;

public class EliminarReservaCommand implements ReservaCommand {
    private final ReservaService reservaService;
    private final long reservaId;

    public EliminarReservaCommand(ReservaService reservaService, long reservaId) {
        this.reservaService = reservaService;
        this.reservaId = reservaId;
    }

    @Override
    public void execute() {
        reservaService.eliminarReserva(reservaId);
    }
}

