package com.reservacomunitaria.app.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reserves")
public class reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate fecha;
    private String hora;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user user;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private place place;

    public reserve(LocalDate fecha, String hora, user user, place place) {
        this.fecha = fecha;
        this.hora = hora;
        this.user = user;
        this.place = place;
    }

    public reserve() {
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public com.reservacomunitaria.app.models.user getUser() {
        return user;
    }

    public void setUser(com.reservacomunitaria.app.models.user user) {
        this.user = user;
    }

    public com.reservacomunitaria.app.models.place getPlace() {
        return place;
    }

    public void setPlace(com.reservacomunitaria.app.models.place place) {
        this.place = place;
    }
}