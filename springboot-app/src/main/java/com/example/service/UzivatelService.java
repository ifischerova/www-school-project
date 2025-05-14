package com.example.service;

import com.example.model.Uzivatel;
import com.example.repository.UzivatelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UzivatelService {
    @Autowired
    private UzivatelRepository userRepository;

    public Uzivatel createUser(Uzivatel user) {
        return userRepository.save(user);
    }

    public Uzivatel getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}