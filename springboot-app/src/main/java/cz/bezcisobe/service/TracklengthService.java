package cz.bezcisobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.bezcisobe.model.TrackLength;
import cz.bezcisobe.repository.TrackLengthRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TracklengthService {
    @Autowired
    private TrackLengthRepository trackLengthRepository;

    public List<TrackLength> findAll() {
        return trackLengthRepository.findAll();
    }

    public Optional<TrackLength> findById(Long id) {
        return trackLengthRepository.findById(id);
    }

    public TrackLength save(TrackLength raceLength) {
        return trackLengthRepository.save(raceLength);
    }

    public void deleteById(Long id) {
        trackLengthRepository.deleteById(id);
    }
}