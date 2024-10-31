package com.reservacomunitaria.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class admin extends person {

    @Enumerated(EnumType.STRING)
    private User.Role role;

    public admin(String username, String email, String password) {
        super(username, email, password);
    }

    public admin() {
        super();
    }

    public User.Role getRole() {
        return role;
    }

    public void setRole(User.Role role) {
        this.role = role;
    }
}
