package com.reservacomunitaria.app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "places")
public class place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private String address;
    private Boolean active;
}
