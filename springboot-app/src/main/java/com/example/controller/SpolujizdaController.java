package com.example.controller;

import com.example.model.Spolujizda;
import com.example.service.SpolujizdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/spolujizda")
public class SpolujizdaController {
    @Autowired
    private SpolujizdaService spolujizdaservice;

    @GetMapping
    public List<Spolujizda> getAll() {
        return spolujizdaservice.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Spolujizda> getById(@PathVariable Long id) {
        return spolujizdaservice.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Spolujizda create(@RequestBody Spolujizda spolujizda) {
        return spolujizdaservice.save(spolujizda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Spolujizda> update(@PathVariable Long id, @RequestBody Spolujizda spolujizda) {
        if (!spolujizdaservice.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(spolujizdaservice.save(spolujizda));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!spolujizdaservice.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        spolujizdaservice.deleteById(id);
        return ResponseEntity.ok().build();
    }
}