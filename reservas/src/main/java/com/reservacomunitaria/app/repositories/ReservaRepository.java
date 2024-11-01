package com.reservacomunitaria.app.repositories;

import com.reservacomunitaria.app.models.Reserve;
import com.reservacomunitaria.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserve, Long> {
    List<Reserve> findByUser(User user);

    List<Reserve> findByUserId(long userId);
}
