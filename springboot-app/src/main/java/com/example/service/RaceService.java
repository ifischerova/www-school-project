package com.example.service;

import com.example.model.Zavod;
import com.example.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceService {
    @Autowired
    private RaceRepository raceRepository;

    public Zavod createRace(Zavod race) {
        return raceRepository.save(race);
    }

    public Zavod getRaceById(Long id) {
        return raceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Race not found"));
    }

    public void deleteRace(Long id) {
        raceRepository.deleteById(id);
    }
}