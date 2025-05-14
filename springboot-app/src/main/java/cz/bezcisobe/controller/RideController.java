package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.Ride;
import cz.bezcisobe.service.RideService;

import java.util.List;

@RestController
@RequestMapping("/api/ride")
public class RideController {
    @Autowired
    private RideService rideService;

    @GetMapping
    public List<Ride> getAll() {
        return rideService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ride> getById(@PathVariable Long id) {
        return rideService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ride create(@RequestBody Ride ride) {
        return rideService.save(ride);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ride> update(@PathVariable Long id, @RequestBody Ride ride) {
        if (!rideService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rideService.save(ride));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!rideService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        rideService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}