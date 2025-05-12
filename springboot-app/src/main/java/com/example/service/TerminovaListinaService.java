package com.example.service;

import com.example.model.TerminovaListina;
import com.example.repository.TerminovaListinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TerminovaListinaService {
    @Autowired
    private TerminovaListinaRepository terminovaListinaRepository;

    public List<TerminovaListina> findAll() {
        return terminovaListinaRepository.findAll();
    }

    public Optional<TerminovaListina> findById(Long id) {
        return terminovaListinaRepository.findById(id);
    }

    public TerminovaListina save(TerminovaListina terminovaListina) {
        return terminovaListinaRepository.save(terminovaListina);
    }

    public void deleteById(Long id) {
        terminovaListinaRepository.deleteById(id);
    }
}