package com.reservacomunitaria.app.services;

import com.reservacomunitaria.app.models.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reservacomunitaria.app.repositories.placeRepository;

import java.util.List;

@Service
public class placeService {
    @Autowired
    private placeRepository placeRepository;

    public List<Place> getAllPlaces(){
        return placeRepository.findAll();
    }

    public void insertPlace(Place newPlace) {
        placeRepository.save(newPlace);
    }

    public void deletePlace(long id) {
        placeRepository.deleteById(id);
    }

    public Place getPlaceById(long id) {
        return placeRepository.findById(id).orElse(null);
    }

    public void updatePlace(Place updatedPlace) {
        placeRepository.save(updatedPlace);
    }
}
