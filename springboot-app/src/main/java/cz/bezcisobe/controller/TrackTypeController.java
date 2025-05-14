package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.TrackType;
import cz.bezcisobe.service.TrackTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/track-type")
public class TrackTypeController {
    @Autowired
    private TrackTypeService trackTypeService;

    @GetMapping
    public List<TrackType> getAllRaceTypes() {
        return trackTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackType> getRaceTypeById(@PathVariable Long id) {
        return trackTypeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TrackType createRaceType(@RequestBody TrackType trackType) {
        return trackTypeService.save(trackType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrackType> updateRaceType(@PathVariable Long id, @RequestBody TrackType trackType) {
        if (!trackTypeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        trackType.setID(id);
        return ResponseEntity.ok(trackTypeService.save(trackType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRaceType(@PathVariable Long id) {
        if (!trackTypeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        trackTypeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}