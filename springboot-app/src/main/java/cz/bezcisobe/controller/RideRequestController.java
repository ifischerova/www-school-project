package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.RideRequest;
import cz.bezcisobe.service.RideRequestService;

import java.util.List;

@RestController
@RequestMapping("/api/ride-request")
public class RideRequestController {
    @Autowired
    private RideRequestService requestService;

    @GetMapping
    public List<RideRequest> getAllRequests() {
        return requestService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RideRequest> getRequestById(@PathVariable Long id) {
        return requestService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<RideRequest> getRequestsByUser(@PathVariable Long userId) {
        return requestService.findByUserId(userId);
    }

    @PostMapping
    public RideRequest createRequest(@RequestBody RideRequest request) {
        return requestService.save(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RideRequest> updateRequest(@PathVariable Long id, @RequestBody RideRequest request) {
        if (!requestService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        request.setID(id);
        return ResponseEntity.ok(requestService.save(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        if (!requestService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        requestService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}