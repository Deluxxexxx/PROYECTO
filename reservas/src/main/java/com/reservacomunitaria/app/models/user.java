package com.reservacomunitaria.app.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class user extends person {

    @OneToMany(mappedBy = "user")
    private List<reserve> reservas;

    @Enumerated(EnumType.STRING)
    private Role role;

    public user(String username, String email, String password) {
        super(username, email, password);
    }

    public user() {
        super();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public enum Role {
        USER, ADMIN
    }
}