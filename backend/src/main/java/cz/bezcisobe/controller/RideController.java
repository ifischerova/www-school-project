package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.Ride;
import cz.bezcisobe.service.RideService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/ride")
@Tag(name = "Ride", description = "Ride management APIs")
public class RideController {
    @Autowired
    private RideService rideService;

    @Operation(
        summary = "Get all rides",
        description = "Returns a list of all rides"
    )
    @ApiResponse(responseCode = "200", description = "Found the Ride")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Ride not found")
    @GetMapping
    public List<Ride> getAll() {
        return rideService.findAll();
    }

    @Operation(
        summary = "Get a ride by ID",
        description = "Returns a ride based on the ID"
    )
    @ApiResponse(responseCode = "200", description = "Found the ride")
    @ApiResponse(responseCode = "404", description = "Ride not found")
    @GetMapping("/{id}")
    public ResponseEntity<Ride> getById(@PathVariable Long id) {
        return rideService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @Operation(
        summary = "Create a new ride",
        description = "Creates a new ride with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Ride created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PostMapping
    public Ride create(@RequestBody Ride ride) {
        return rideService.save(ride);
    }

    @Operation(
      summary = "Update an existing ride",
      description = "Updates an existing ride with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Ride updated successfully")
    @ApiResponse(responseCode = "404", description = "Ride not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")   
    @PutMapping("/{id}")
    public ResponseEntity<Ride> update(@PathVariable Long id, @RequestBody Ride ride) {
        if (!rideService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rideService.save(ride));
    }

    @Operation(
        summary = "Delete a ride",
        description = "Deletes ride."
    )
    @ApiResponse(responseCode = "204", description = "Ride deleted.")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "404", description = "Ride not found.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!rideService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        rideService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}