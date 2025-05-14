package com.example.repository;

import com.example.model.Cestujici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.CestujiciId;

@Repository
public interface CestujiciRepository extends JpaRepository<Cestujici, CestujiciId> {
}