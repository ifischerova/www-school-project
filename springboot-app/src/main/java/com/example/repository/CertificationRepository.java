package com.example.repository;

import com.example.model.Certifikace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends JpaRepository<Certifikace, Long> {
}