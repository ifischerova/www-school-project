package com.example.repository;

import com.example.model.Zavod;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;

public interface ZavodRepository extends JpaRepository<Zavod, Long> {
    List<Zavod> findByDatumKonaniAfter(LocalDate date);
}