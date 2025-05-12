package com.example.service;

import com.example.model.DruhTrate;
import com.example.repository.RaceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RaceTypeService {
    @Autowired
    private RaceTypeRepository raceTypeRepository;

    public List<DruhTrate> findAll() {
        return raceTypeRepository.findAll();
    }

    public Optional<DruhTrate> findById(Long id) {
        return raceTypeRepository.findById(id);
    }

    public DruhTrate save(DruhTrate raceType) {
        return raceTypeRepository.save(raceType);
    }

    public void deleteById(Long id) {
        raceTypeRepository.deleteById(id);
    }
}