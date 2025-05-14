package cz.bezcisobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.bezcisobe.model.Race;
import cz.bezcisobe.repository.RaceRepository;

@Service
public class RaceService {
    @Autowired
    private RaceRepository raceRepository;

    public Race createRace(Race race) {
        return raceRepository.save(race);
    }

    public Race getRaceById(Long id) {
        return raceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Race not found"));
    }

    public Race updateRace(Long id, Race raceDetails) {
        Race race = getRaceById(id);

        if (raceDetails.getName() != null) {
            race.setName(raceDetails.getName());
        }
        if (raceDetails.getPlace() != null) {
            race.setPlace(raceDetails.getPlace());
        }
        if (raceDetails.getDate() != null) {
            race.setDate(raceDetails.getDate());
        }
        if (raceDetails.getStartTime() != null) {
            race.setStartTime(raceDetails.getStartTime());
        }
        if (raceDetails.getWeb() != null) {
            race.setWeb(raceDetails.getWeb());
        }
        
        return raceRepository.save(race);
    }

    public void deleteRace(Long id) {
        raceRepository.deleteById(id);
    }
}