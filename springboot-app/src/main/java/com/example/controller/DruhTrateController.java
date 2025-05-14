package com.example.controller;

import com.example.model.DruhTrate;
import com.example.service.DruhTrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/race-types")
public class DruhTrateController {
    @Autowired
    private DruhTrateService raceTypeService;

    @GetMapping
    public List<DruhTrate> getAllRaceTypes() {
        return raceTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DruhTrate> getRaceTypeById(@PathVariable Long id) {
        return raceTypeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DruhTrate createRaceType(@RequestBody DruhTrate raceType) {
        return raceTypeService.save(raceType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DruhTrate> updateRaceType(@PathVariable Long id, @RequestBody DruhTrate raceType) {
        if (!raceTypeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        raceType.setID(id);
        return ResponseEntity.ok(raceTypeService.save(raceType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRaceType(@PathVariable Long id) {
        if (!raceTypeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        raceTypeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}