package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.RaceLength;
import cz.bezcisobe.service.TrackLengthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/track-length")
@Tag(name = "Track Length", description = "Track Length management APIs")
public class TrackLengthController {
    @Autowired
    private TrackLengthService RaceLengthService;

    @Operation(
        summary = "Get all track lenghts",
        description = "Returns a list of all track lengths"
    )
    @ApiResponse(responseCode = "200", description = "Found the track lengths")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Track lenghts not found")
    @GetMapping
    public List<RaceLength> getAllRaceLengths() {
        return RaceLengthService.findAll();
    }

    @Operation(
        summary = "Get a track length by ID",
        description = "Returns a track length based on the ID"
    )
    @ApiResponse(responseCode = "200", description = "Found the track length")
    @ApiResponse(responseCode = "404", description = "Track length not found")
    @GetMapping("/{id}")
    public ResponseEntity<RaceLength> getRaceLengthById(@PathVariable Long id) {
        return RaceLengthService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Create a new track length",
        description = "Creates a new track length with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Track length created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PostMapping
    public RaceLength createRaceLength(@RequestBody RaceLength trackLength) {
        return RaceLengthService.save(trackLength);
    }

    @Operation(
      summary = "Update an existing track length",
      description = "Updates an existing track length with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Track length updated successfully")
    @ApiResponse(responseCode = "404", description = "Track length not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PutMapping("/{id}")
    public ResponseEntity<RaceLength> updateRaceLength(@PathVariable Long id, @RequestBody RaceLength trackLength) {
        if (!RaceLengthService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        trackLength.setID(id);
        return ResponseEntity.ok(RaceLengthService.save(trackLength));
    }

    @Operation(
        summary = "Delete a certification",
        description = "Deletes certification."
    )
    @ApiResponse(responseCode = "204", description = "Certification deleted.")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "404", description = "Certification not found.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRaceLength(@PathVariable Long id) {
        if (!RaceLengthService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        RaceLengthService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}