package cz.bezcisobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.bezcisobe.model.RaceCalendar;
import cz.bezcisobe.repository.RaceCalendarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RaceCalendarService {
    @Autowired
    private RaceCalendarRepository raceCalendarRepository;

    public List<RaceCalendar> findAll() {
        return raceCalendarRepository.findAll();
    }

    public Optional<RaceCalendar> findById(Long id) {
        return raceCalendarRepository.findById(id);
    }

    public RaceCalendar save(RaceCalendar terminovaListina) {
        return raceCalendarRepository.save(terminovaListina);
    }

    public void deleteById(Long id) {
        raceCalendarRepository.deleteById(id);
    }
}