package com.reservacomunitaria.app.repositories;

import com.reservacomunitaria.app.models.admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface adminRepository extends JpaRepository<admin, Long> {
    admin findByEmailAndPassword(String email, String password);
}

