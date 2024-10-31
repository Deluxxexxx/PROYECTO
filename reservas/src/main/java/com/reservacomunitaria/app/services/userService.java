package com.reservacomunitaria.app.services;

import com.reservacomunitaria.app.models.admin;
import com.reservacomunitaria.app.models.User;
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

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).orElse(null);
    }

    public admin getAdminByEmailAndPassword(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }



    public User registerUser(User user) {

        if (userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()).isPresent()) {
            throw new RuntimeException("El email ya se encuentra registrado");
        }

        user.setRole(User.Role.USER);

        User newUser = userRepository.save(user);
        return newUser;
    }
}