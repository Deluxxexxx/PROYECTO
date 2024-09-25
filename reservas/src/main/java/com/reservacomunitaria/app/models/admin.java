package com.reservacomunitaria.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class admin extends person {

    @Enumerated(EnumType.STRING)
    private user.Role role;

    public admin(String username, String email, String password) {
        super(username, email, password);
    }

    public admin() {
        super();
    }

    public user.Role getRole() {
        return role;
    }

    public void setRole(user.Role role) {
        this.role = role;
    }
}
