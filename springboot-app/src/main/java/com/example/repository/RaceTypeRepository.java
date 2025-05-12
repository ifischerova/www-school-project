package com.example.repository;

import com.example.model.DruhTrate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceTypeRepository extends JpaRepository<DruhTrate, Long> {
}