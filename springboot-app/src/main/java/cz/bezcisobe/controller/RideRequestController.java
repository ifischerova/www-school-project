package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.RideRequest;
import cz.bezcisobe.service.RideRequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/ride-request")
@Tag(name = "Ride Request", description = "Ride Request management APIs")
public class RideRequestController {
    @Autowired
    private RideRequestService requestService;

    @Operation(
        summary = "Get all ride requests",
        description = "Returns a list of all ride requests"
    )
    @ApiResponse(responseCode = "200", description = "Found the ride request")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Ride requests not found")
    @GetMapping
    public List<RideRequest> getAllRequests() {
        return requestService.findAll();
    }

    @Operation(
        summary = "Get a ride request by ID",
        description = "Returns a ride request based on the ID"
    )
    @ApiResponse(responseCode = "200", description = "Found the ride request")
    @ApiResponse(responseCode = "404", description = "Ride request not found")
    @GetMapping("/{id}")
    public ResponseEntity<RideRequest> getRequestById(@PathVariable Long id) {
        return requestService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Get a ride request by user",
        description = "Returns a ride request based on the user"
    )
    @ApiResponse(responseCode = "200", description = "Found the ride request")
    @ApiResponse(responseCode = "404", description = "Ride request not found")
    @GetMapping("/user/{userId}")
    public List<RideRequest> getRequestsByUser(@PathVariable Long userId) {
        return requestService.findByUserId(userId);
    }

    @Operation(
        summary = "Create a new ide request",
        description = "Creates a new ride request with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Ride Request created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PostMapping
    public RideRequest createRequest(@RequestBody RideRequest request) {
        return requestService.save(request);
    }

    @Operation(
      summary = "Update an existing ride request",
      description = "Updates an existing ride request with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Ride request updated successfully")
    @ApiResponse(responseCode = "404", description = "Ride request not found")
    @ApiResponse(responseCode = "400", description = "Invalid input") 
    @PutMapping("/{id}")
    public ResponseEntity<RideRequest> updateRequest(@PathVariable Long id, @RequestBody RideRequest request) {
        if (!requestService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        request.setID(id);
        return ResponseEntity.ok(requestService.save(request));
    }

    @Operation(
        summary = "Delete a ride request",
        description = "Deletes ride request."
    )
    @ApiResponse(responseCode = "204", description = "Ride request deleted.")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "404", description = "Ride request not found.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        if (!requestService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        requestService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}