package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.TrackLength;
import cz.bezcisobe.service.TracklengthService;

import java.util.List;

@RestController
@RequestMapping("/api/track-length")
public class TrackLengthController {
    @Autowired
    private TracklengthService trackLengthService;

    @GetMapping
    public List<TrackLength> getAllRaceLengths() {
        return trackLengthService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackLength> getRaceLengthById(@PathVariable Long id) {
        return trackLengthService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TrackLength createRaceLength(@RequestBody TrackLength trackLength) {
        return trackLengthService.save(trackLength);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrackLength> updateRaceLength(@PathVariable Long id, @RequestBody TrackLength trackLength) {
        if (!trackLengthService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        trackLength.setID(id);
        return ResponseEntity.ok(trackLengthService.save(trackLength));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRaceLength(@PathVariable Long id) {
        if (!trackLengthService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        trackLengthService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}