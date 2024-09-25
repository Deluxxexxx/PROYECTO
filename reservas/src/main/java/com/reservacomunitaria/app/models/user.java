package com.reservacomunitaria.app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class user extends person {

    public user(String username, String email, String password) {
        super(username, email, password);
    }

    public user() {
        super();
    }
}