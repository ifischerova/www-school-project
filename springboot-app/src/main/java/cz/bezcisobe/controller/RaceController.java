package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.Race;
import cz.bezcisobe.service.RaceService;

@RestController
@RequestMapping("/api/race")
public class RaceController {
    @Autowired
    private RaceService raceService;

    @PostMapping
    public ResponseEntity<Race> createRace(@RequestBody Race race) {
        return ResponseEntity.ok(raceService.createRace(race));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Race> getRace(@PathVariable Long id) {
        return ResponseEntity.ok(raceService.getRaceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Race> updateRace(@PathVariable Long id, @RequestBody Race raceDetails) {
        Race updatedRace = raceService.updateRace(id, raceDetails);
        return ResponseEntity.ok(updatedRace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRace(@PathVariable Long id) {
        raceService.deleteRace(id);
        return ResponseEntity.ok().build();
    }
}