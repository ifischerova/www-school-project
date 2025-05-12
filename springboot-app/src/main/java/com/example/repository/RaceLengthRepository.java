package com.example.repository;

import com.example.model.DelkaTrate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceLengthRepository extends JpaRepository<DelkaTrate, Long> {
}