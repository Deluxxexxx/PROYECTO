package com.reservacomunitaria.app.repositories;

import com.reservacomunitaria.app.models.reserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface reserveRepository extends JpaRepository<reserve, Long> {
    List<reserve> findByUserId(Long id);
}