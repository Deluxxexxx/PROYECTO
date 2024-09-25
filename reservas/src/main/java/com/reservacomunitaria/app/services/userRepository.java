package com.reservacomunitaria.app.services;

import com.reservacomunitaria.app.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<user, Long> {

    @Query(value = "SELECT * FROM users WHERE EMAIL = ?1 AND PASSWORD = ?2", nativeQuery = true)
    <Optional> java.util.Optional<user> findByEmailAndPassword(String email, String password);

    @Query(value = "INSERT INTO users(EMAIL,PASSWORD,USERNAME) VALUES(?1,?2,?3)", nativeQuery = true)
    void register(String email, String password, String username);
}
