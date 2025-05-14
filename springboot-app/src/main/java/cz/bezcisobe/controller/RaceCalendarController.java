package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.RaceCalendar;
import cz.bezcisobe.service.RaceCalendarService;

import java.util.List;

@RestController
@RequestMapping("/api/race-calendar")
public class RaceCalendarController {
    @Autowired
    private RaceCalendarService raceCalendarService;

    @GetMapping
    public List<RaceCalendar> getAllTerminovaListina() {
        return raceCalendarService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RaceCalendar> getTerminovaListinaById(@PathVariable Long id) {
        return raceCalendarService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RaceCalendar createTerminovaListina(@RequestBody RaceCalendar raceCalendar) {
        return raceCalendarService.save(raceCalendar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RaceCalendar> updateTerminovaListina(@PathVariable Long id, 
                                                                  @RequestBody RaceCalendar raceCalendar) {
        if (!raceCalendarService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        raceCalendar.setID(id);
        return ResponseEntity.ok(raceCalendarService.save(raceCalendar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerminovaListina(@PathVariable Long id) {
        if (!raceCalendarService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        raceCalendarService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}