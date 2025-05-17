package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.Passenger;
import cz.bezcisobe.model.PassengerId;
import cz.bezcisobe.service.PassengerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/passenger")
@Tag(name = "Passenger", description = "Passenger Manipulation APIs")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @Operation(
         summary = "Get all passengers",
        description = "Returns a list of all passengers"
    )
    @ApiResponse(responseCode = "200", description = "Found the passengers.")
    @ApiResponse(responseCode = "400", description = "Invalid request.")
    @GetMapping
    public List<Passenger> getAll() {
        return passengerService.findAll();
    }

    @Operation(
        summary = "Get a passenger by ID",
        description = "Returns a passenger based on the ID"
    )
    @ApiResponse(responseCode = "200", description = "Found the passenger.")
    @ApiResponse(responseCode = "400", description = "Invalid request.")
    @ApiResponse(responseCode = "404", description = "Passenger not found.")
    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getById(@PathVariable PassengerId id) {
        return passengerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @Operation(
        summary = "Create a new passenger.",
        description = "Creates a new passenger with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Passenger created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PostMapping
    public Passenger create(@RequestBody Passenger cestujici) {
        return passengerService.save(cestujici);
    }

    @Operation(
        summary = "Update an existing passenger ",
        description = "Updates an existing passenger with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Passenger updated successfully")
    @ApiResponse(responseCode = "404", description = "Passenger not found")
    @ApiResponse(responseCode = "400", description = "Invalid input") 
    @PutMapping("/{id}")
    public ResponseEntity<Passenger> update(@PathVariable PassengerId id, @RequestBody Passenger passenger) {
        if (!passengerService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passengerService.save(passenger));
    }

    @Operation(
        summary = "Delete a passenger",
        description = "Deletes passenger."
    )
    @ApiResponse(responseCode = "204", description = "Passenger deleted.")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "404", description = "Passenger not found.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable PassengerId id) {
        if (!passengerService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        passengerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}