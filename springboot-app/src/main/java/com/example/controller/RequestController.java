package com.example.controller;

import com.example.model.Poptavka;
import com.example.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @GetMapping
    public List<Poptavka> getAllRequests() {
        return requestService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poptavka> getRequestById(@PathVariable Long id) {
        return requestService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<Poptavka> getRequestsByUser(@PathVariable Long userId) {
        return requestService.findByUserId(userId);
    }

    @PostMapping
    public Poptavka createRequest(@RequestBody Poptavka request) {
        return requestService.save(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Poptavka> updateRequest(@PathVariable Long id, @RequestBody Poptavka request) {
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