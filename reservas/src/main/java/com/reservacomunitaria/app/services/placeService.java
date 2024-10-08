package com.reservacomunitaria.app.services;

import com.reservacomunitaria.app.models.place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reservacomunitaria.app.repositories.placeRepository;

import java.util.List;

@Service
public class placeService {
    @Autowired
    private placeRepository placeRepository;

    public List<place> getAllPlaces(){
        return placeRepository.findAll();
    }

    public void insertPlace(place newPlace) {
        placeRepository.save(newPlace);
    }

    public void deletePlace(long id) {
        placeRepository.deleteById(id);
    }

    public place getPlaceById(long id) {
        return placeRepository.findById(id).orElse(null);
    }

    public void updatePlace(place updatedPlace) {
        placeRepository.save(updatedPlace);
    }
}
