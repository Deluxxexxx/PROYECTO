package com.reservacomunitaria.app.services;

import com.reservacomunitaria.app.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<user, Long> {

    @Query(value = "SELECT * FROM users WHERE email = ?1 && password = ?2", nativeQuery = true)
    <Optional> java.util.Optional<user> findByEmailAndPassword(String email, String password);
}
