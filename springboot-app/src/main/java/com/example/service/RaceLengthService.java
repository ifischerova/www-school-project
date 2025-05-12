package com.example.service;

import com.example.model.DelkaTrate;
import com.example.repository.RaceLengthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RaceLengthService {
    @Autowired
    private RaceLengthRepository raceLengthRepository;

    public List<DelkaTrate> findAll() {
        return raceLengthRepository.findAll();
    }

    public Optional<DelkaTrate> findById(Long id) {
        return raceLengthRepository.findById(id);
    }

    public DelkaTrate save(DelkaTrate raceLength) {
        return raceLengthRepository.save(raceLength);
    }

    public void deleteById(Long id) {
        raceLengthRepository.deleteById(id);
    }
}