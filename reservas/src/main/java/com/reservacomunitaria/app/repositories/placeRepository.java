package com.reservacomunitaria.app.repositories;

import com.reservacomunitaria.app.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface placeRepository extends JpaRepository<Place, Long> {
    //@Query(value = "SELECT * FROM places")
    //<Optional> java.util.Optional<place> findAllPlaces();

    //@Query(value = "INSERT INTO places (name, description, capacity, address, available) VALUES (?1, ?2, ?3, ?4, ?5)")
    //void insertPlace(String name, String description, int capacity, String address, boolean available);
}
