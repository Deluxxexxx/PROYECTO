package com.reservacomunitaria.app.commands;
import com.reservacomunitaria.app.models.Reserve;
import com.reservacomunitaria.app.services.ReservaService;

public class CrearReservaCommand implements ReservaCommand {
    private final ReservaService reserveService;
    private final Reserve reserve;

    public CrearReservaCommand(ReservaService reserveService, Reserve reserve) {
        this.reserveService = reserveService;
        this.reserve = reserve;
    }

    @Override
    public void execute() {
        reserveService.guardarReserva(reserve);
    }
}

