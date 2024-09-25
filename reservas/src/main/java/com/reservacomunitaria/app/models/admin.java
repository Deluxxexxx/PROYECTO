package com.reservacomunitaria.app.models;

import jakarta.persistence.Entity;

@Entity
public class admin extends person {

    public admin(String username, String email, String password) {
        super(username, email, password);
    }

    public admin() {
        super();
    }
}
