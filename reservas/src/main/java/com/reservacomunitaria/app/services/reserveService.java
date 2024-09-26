package com.reservacomunitaria.app.services;

import com.reservacomunitaria.app.models.reserve;
import com.reservacomunitaria.app.repositories.reserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reserveService {

    @Autowired
    private reserveRepository reserveRepository;

    public List<reserve> getReservesByUserId(long userId) {
        return reserveRepository.findByUserId(userId);
    }

    public reserve getReserveById(long reserveId) {
        return reserveRepository.findById(reserveId).orElse(null);
    }

    public void createReserve(reserve newReserve) {
        reserveRepository.save(newReserve);
    }

    public void updateReserve(reserve existingReserve) {
        reserveRepository.save(existingReserve);
    }

    public void deleteReserve(long reserveId) {
        reserveRepository.deleteById(reserveId);
    }
}

