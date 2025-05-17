package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.TrackType;
import cz.bezcisobe.service.TrackTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/track-type")
@Tag(name = "Track Type", description = "Track Type management APIs")
public class TrackTypeController {
    @Autowired
    private TrackTypeService trackTypeService;

    @Operation(
        summary = "Get all race types",
        description = "Returns a list of all race types"
    )
    @ApiResponse(responseCode = "200", description = "Found the race types")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Race types not found")
    @GetMapping
    public List<TrackType> getAllRaceTypes() {
        return trackTypeService.findAll();
    }

    @Operation(
        summary = "Get a race type by ID",
        description = "Returns a race type based on the ID"
    )
    @ApiResponse(responseCode = "200", description = "Found the race type")
    @ApiResponse(responseCode = "404", description = "Race type not found")
    @GetMapping("/{id}")
    public ResponseEntity<TrackType> getRaceTypeById(@PathVariable Long id) {
        return trackTypeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Create a new race type",
        description = "Creates a new race type with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Race type created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PostMapping
    public TrackType createRaceType(@RequestBody TrackType trackType) {
        return trackTypeService.save(trackType);
    }

    @Operation(
        summary = "Update an existing race type",
        description = "Updates an existing race type with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Race type updated successfully")
    @ApiResponse(responseCode = "404", description = "Race type not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")    
    @PutMapping("/{id}")
    public ResponseEntity<TrackType> updateRaceType(@PathVariable Long id, @RequestBody TrackType trackType) {
        if (!trackTypeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        trackType.setID(id);
        return ResponseEntity.ok(trackTypeService.save(trackType));
    }

    @Operation(
        summary = "Delete a race type",
        description = "Deletes race type."
    )
    @ApiResponse(responseCode = "204", description = "Race type deleted.")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "404", description = "Race type not found.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRaceType(@PathVariable Long id) {
        if (!trackTypeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        trackTypeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}