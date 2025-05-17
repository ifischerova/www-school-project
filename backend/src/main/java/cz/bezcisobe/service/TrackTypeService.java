package cz.bezcisobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.bezcisobe.model.TrackType;
import cz.bezcisobe.repository.TrackTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TrackTypeService {
    @Autowired
    private TrackTypeRepository trackTypeRepository;

    public List<TrackType> findAll() {
        return trackTypeRepository.findAll();
    }

    public Optional<TrackType> findById(Long id) {
        return trackTypeRepository.findById(id);
    }

    public TrackType save(TrackType raceType) {
        return trackTypeRepository.save(raceType);
    }

    public void deleteById(Long id) {
        trackTypeRepository.deleteById(id);
    }
}