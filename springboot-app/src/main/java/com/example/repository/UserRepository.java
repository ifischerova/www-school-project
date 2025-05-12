package com.example.repository;

import com.example.model.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Uzivatel, Long> {
    Uzivatel findByUzivatelskeJmeno(String username);
    Uzivatel findByEmail(String email);
}
