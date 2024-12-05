package com.reservacomunitaria.app;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;



@Component
public class Logger {

    private static final String LOG_FILE = "logs.txt";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mma");

    public static void log(String usuario, String mensaje) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(DATE_FORMAT.format(LocalDateTime.now()) + " - " + usuario + " - " + mensaje);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de log: " + e.getMessage());
        }
    }

    public static void log(String usuario, String accion, String resultado) {
        log(usuario, accion + " - " + resultado);
    }
}
