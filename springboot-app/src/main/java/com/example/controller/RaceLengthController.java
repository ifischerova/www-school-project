package com.example.controller;

import com.example.model.DelkaTrate;
import com.example.service.RaceLengthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/race-lengths")
public class RaceLengthController {
    @Autowired
    private RaceLengthService raceLengthService;

    @GetMapping
    public List<DelkaTrate> getAllRaceLengths() {
        return raceLengthService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DelkaTrate> getRaceLengthById(@PathVariable Long id) {
        return raceLengthService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DelkaTrate createRaceLength(@RequestBody DelkaTrate raceLength) {
        return raceLengthService.save(raceLength);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DelkaTrate> updateRaceLength(@PathVariable Long id, @RequestBody DelkaTrate raceLength) {
        if (!raceLengthService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        raceLength.setID(id);
        return ResponseEntity.ok(raceLengthService.save(raceLength));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRaceLength(@PathVariable Long id) {
        if (!raceLengthService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        raceLengthService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}