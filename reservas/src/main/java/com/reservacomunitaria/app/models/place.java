package com.reservacomunitaria.app.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "places")
public class place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<reserve> reservas;

    private String name;
    private String description;
    private int capacity;
    private String address;
    private Boolean available;

    public place(String name, String description, int capacity, String address, Boolean available) {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.address = address;
        this.available = available;
    }

    public place() {
    }

    public List<reserve> getReservas() {
        return reservas;
    }

    public void setReservas(List<reserve> reservas) {
        this.reservas = reservas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
