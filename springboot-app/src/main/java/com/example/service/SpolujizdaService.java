package com.example.service;

import com.example.model.Spolujizda;
import com.example.repository.SpolujizdaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SpolujizdaService {
    @Autowired
    private SpolujizdaRepository spolujizdarepository;

    public List<Spolujizda> findAll() {
        return spolujizdarepository.findAll();
    }

    public Optional<Spolujizda> findById(Long id) {
        return spolujizdarepository.findById(id);
    }

    public Spolujizda save(Spolujizda spolujizda) {
        return spolujizdarepository.save(spolujizda);
    }

    public void deleteById(Long id) {
        spolujizdarepository.deleteById(id);
    }
}