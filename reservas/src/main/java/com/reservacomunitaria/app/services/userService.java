package com.reservacomunitaria.app.services;

import com.reservacomunitaria.app.models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class userService {
    @Autowired
    private userRepository userRepository;

    public user getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).orElse(null);
    }

    public  user registerUser(user user) {
        user newUser = userRepository.save(user);
        return newUser;
    }
}