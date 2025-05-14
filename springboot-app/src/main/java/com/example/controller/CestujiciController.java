package com.example.controller;

import com.example.model.Cestujici;
import com.example.model.CestujiciId;
import com.example.service.CestujiciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cestujici")
public class CestujiciController {
    @Autowired
    private CestujiciService cestujiciService;

    @GetMapping
    public List<Cestujici> getAll() {
        return cestujiciService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cestujici> getById(@PathVariable CestujiciId id) {
        return cestujiciService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cestujici create(@RequestBody Cestujici cestujici) {
        return cestujiciService.save(cestujici);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cestujici> update(@PathVariable CestujiciId id, @RequestBody Cestujici cestujici) {
        if (!cestujiciService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cestujiciService.save(cestujici));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable CestujiciId id) {
        if (!cestujiciService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cestujiciService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}