package com.reservacomunitaria.app.repositories;

import com.reservacomunitaria.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE EMAIL = ?1 AND PASSWORD = ?2", nativeQuery = true)
    <Optional> java.util.Optional<User> findByEmailAndPassword(String email, String password);

    @Query(value = "INSERT INTO users(EMAIL,PASSWORD,USERNAME) VALUES(?1,?2,?3)", nativeQuery = true)
    void register(String email, String password, String username);

    User findByUsername(String username);

    User findByEmail(String email);
}
