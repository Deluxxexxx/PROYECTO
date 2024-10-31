package com.reservacomunitaria.app.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User extends person {

    @OneToMany(mappedBy = "user")
    private List<Reserve> reservas;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String username, String email, String password) {
        super(username, email, password);
    }

    public User() {
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