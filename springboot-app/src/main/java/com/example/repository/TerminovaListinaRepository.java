package com.example.repository;

import com.example.model.TerminovaListina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminovaListinaRepository extends JpaRepository<TerminovaListina, Long> {
}