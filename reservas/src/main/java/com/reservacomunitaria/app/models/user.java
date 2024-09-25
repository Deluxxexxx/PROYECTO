package com.reservacomunitaria.app.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class user extends person {

    @OneToMany(mappedBy = "user")
    private List<reserve> reservas;

    public user(String username, String email, String password) {
        super(username, email, password);
    }

    public user() {
        super();
    }
}