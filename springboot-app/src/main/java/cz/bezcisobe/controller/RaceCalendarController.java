package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.RaceCalendar;
import cz.bezcisobe.service.RaceCalendarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/race-calendar")
@Tag(name = "RaceCalendar", description = "Race Calendar management APIs")
public class RaceCalendarController {
    @Autowired
    private RaceCalendarService raceCalendarService;

    @Operation(
        summary = "Get all race calendars",
        description = "Returns a list of all race calendars"
    )
    @ApiResponse(responseCode = "200", description = "Found the race calendar")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "race calendars not found")
    @GetMapping
    public List<RaceCalendar> getAllTerminovaListina() {
        return raceCalendarService.findAll();
    }

    @Operation(
        summary = "Get a race calendar by ID",
        description = "Returns a race calendar based on the ID"
    )
    @ApiResponse(responseCode = "200", description = "Found the race calendar")
    @ApiResponse(responseCode = "404", description = "Race calendar not found")
    @GetMapping("/{id}")
    public ResponseEntity<RaceCalendar> getTerminovaListinaById(@PathVariable Long id) {
        return raceCalendarService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Create a new race calendar",
        description = "Creates a new race calendar with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "race calendar created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PostMapping
    public RaceCalendar createTerminovaListina(@RequestBody RaceCalendar raceCalendar) {
        return raceCalendarService.save(raceCalendar);
    }


    @Operation(
      summary = "Update an existing race calendar",
      description = "Updates an existing race calendar with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Race calendar updated successfully")
    @ApiResponse(responseCode = "404", description = "Race Calendar not found")
    @ApiResponse(responseCode = "400", description = "Invalid input") 
    @PutMapping("/{id}")
    public ResponseEntity<RaceCalendar> updateTerminovaListina(@PathVariable Long id, 
    @RequestBody RaceCalendar raceCalendar) {
        if (!raceCalendarService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        raceCalendar.setID(id);
        return ResponseEntity.ok(raceCalendarService.save(raceCalendar));
    }

    @Operation(
        summary = "Delete a race calendar",
        description = "Deletes race calendar."
    )
    @ApiResponse(responseCode = "204", description = "Race calendar deleted.")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "404", description = "Race calendar not found.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerminovaListina(@PathVariable Long id) {
        if (!raceCalendarService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        raceCalendarService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}