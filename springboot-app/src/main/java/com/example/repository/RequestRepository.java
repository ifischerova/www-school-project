package com.example.repository;

import com.example.model.Poptavka;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RequestRepository extends JpaRepository<Poptavka, Long> {
    List<Poptavka> findByUzivatelID(Long userId);
}