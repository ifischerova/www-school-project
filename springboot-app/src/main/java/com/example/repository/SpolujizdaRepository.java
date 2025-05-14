package com.example.repository;

import com.example.model.Spolujizda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpolujizdaRepository extends JpaRepository<Spolujizda, Long> {
}