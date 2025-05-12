package com.example.controller;

import com.example.model.Zavod;
import com.example.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/races")
public class RaceController {
    @Autowired
    private RaceService raceService;

    @PostMapping
    public ResponseEntity<Zavod> createRace(@RequestBody Zavod race) {
        return ResponseEntity.ok(raceService.createRace(race));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zavod> getRace(@PathVariable Long id) {
        return ResponseEntity.ok(raceService.getRaceById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRace(@PathVariable Long id) {
        raceService.deleteRace(id);
        return ResponseEntity.ok().build();
    }
}