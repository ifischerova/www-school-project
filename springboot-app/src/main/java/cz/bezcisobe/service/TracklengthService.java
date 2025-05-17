package cz.bezcisobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.bezcisobe.model.RaceLength;
import cz.bezcisobe.repository.TrackLengthRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TrackLengthService {
    @Autowired
    private TrackLengthRepository trackLengthRepository;

    public List<RaceLength> findAll() {
        return trackLengthRepository.findAll();
    }

    public Optional<RaceLength> findById(Long id) {
        return trackLengthRepository.findById(id);
    }

    public RaceLength save(RaceLength raceLength) {
        return trackLengthRepository.save(raceLength);
    }

    public void deleteById(Long id) {
        trackLengthRepository.deleteById(id);
    }
}