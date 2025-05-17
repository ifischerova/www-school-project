package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.Race;
import cz.bezcisobe.service.RaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/race")
@Tag(name = "Race", description = "Race management APIs")
public class RaceController {
    @Autowired
    private RaceService raceService;

    @Operation(
      summary = "Create a new race",
      description = "Creates a new race with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Race created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PostMapping
    public ResponseEntity<Race> createRace(@RequestBody Race race) {
        return ResponseEntity.ok(raceService.createRace(race));
    }

    @Operation(
      summary = "Get a race by ID",
      description = "Returns a race based on the ID"
    )
    @ApiResponse(responseCode = "200", description = "Race the certification")
    @ApiResponse(responseCode = "404", description = "Race not found")
    @GetMapping("/{id}")
    public ResponseEntity<Race> getRace(@PathVariable Long id) {
        return ResponseEntity.ok(raceService.getRaceById(id));
    }

    @Operation(
      summary = "Update an existing race",
      description = "Updates an existing race with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Race updated successfully")
    @ApiResponse(responseCode = "404", description = "Race not found")
    @ApiResponse(responseCode = "400", description = "Invalid input") 
    @PutMapping("/{id}")
    public ResponseEntity<Race> updateRace(@PathVariable Long id, @RequestBody Race raceDetails) {
        Race updatedRace = raceService.updateRace(id, raceDetails);
        return ResponseEntity.ok(updatedRace);
    }

    @Operation(
        summary = "Delete a race",
        description = "Deletes race."
    )
    @ApiResponse(responseCode = "204", description = "Race deleted.")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "404", description = "Race not found.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRace(@PathVariable Long id) {
        raceService.deleteRace(id);
        return ResponseEntity.ok().build();
    }
}