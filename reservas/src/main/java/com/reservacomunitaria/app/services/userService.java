package com.reservacomunitaria.app.services;

import com.reservacomunitaria.app.models.admin;
import com.reservacomunitaria.app.models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reservacomunitaria.app.repositories.userRepository;
import com.reservacomunitaria.app.repositories.adminRepository;

@Service
public class userService {
    @Autowired
    private userRepository userRepository;

    @Autowired
    private adminRepository adminRepository;

    public user getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).orElse(null);
    }

    public admin getAdminByEmailAndPassword(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }



    public  user registerUser(user user) {

        if (userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()).isPresent()) {
            throw new RuntimeException("El email ya se encuentra registrado");
        }

        user.setRole(com.reservacomunitaria.app.models.user.Role.USER);

        user newUser = userRepository.save(user);
        return newUser;
    }
}