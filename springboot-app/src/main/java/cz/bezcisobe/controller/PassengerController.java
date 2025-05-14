package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.Passenger;
import cz.bezcisobe.model.PassengerId;
import cz.bezcisobe.service.PassengerService;

import java.util.List;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public List<Passenger> getAll() {
        return passengerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getById(@PathVariable PassengerId id) {
        return passengerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Passenger create(@RequestBody Passenger cestujici) {
        return passengerService.save(cestujici);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> update(@PathVariable PassengerId id, @RequestBody Passenger passenger) {
        if (!passengerService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passengerService.save(passenger));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable PassengerId id) {
        if (!passengerService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        passengerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}