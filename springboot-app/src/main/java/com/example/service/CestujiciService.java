package com.example.service;

import com.example.model.Cestujici;
import com.example.model.CestujiciId;
import com.example.repository.CestujiciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CestujiciService {
    @Autowired
    private CestujiciRepository cestujiciRepository;

    public List<Cestujici> findAll() {
        return cestujiciRepository.findAll();
    }

    public Optional<Cestujici> findById(CestujiciId id) {
        return cestujiciRepository.findById(id);
    }

    public Cestujici save(Cestujici cestujici) {
        return cestujiciRepository.save(cestujici);
    }

    public void deleteById(CestujiciId id) {
        cestujiciRepository.deleteById(id);
    }
}