package com.example.service;

import com.example.model.Poptavka;
import com.example.repository.PoptavkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PoptavkaService {
    @Autowired
    private PoptavkaRepository requestRepository;

    public List<Poptavka> findAll() {
        return requestRepository.findAll();
    }

    public Optional<Poptavka> findById(Long id) {
        return requestRepository.findById(id);
    }

    public List<Poptavka> findByUserId(Long userId) {
        return requestRepository.findByUzivatelID(userId);
    }

    public Poptavka save(Poptavka request) {
        return requestRepository.save(request);
    }

    public void deleteById(Long id) {
        requestRepository.deleteById(id);
    }
}