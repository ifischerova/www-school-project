package com.example.controller;

import com.example.model.TerminovaListina;
import com.example.service.TerminovaListinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/terminova-listina")
public class TerminovaListinaController {
    @Autowired
    private TerminovaListinaService terminovaListinaService;

    @GetMapping
    public List<TerminovaListina> getAllTerminovaListina() {
        return terminovaListinaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TerminovaListina> getTerminovaListinaById(@PathVariable Long id) {
        return terminovaListinaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TerminovaListina createTerminovaListina(@RequestBody TerminovaListina terminovaListina) {
        return terminovaListinaService.save(terminovaListina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TerminovaListina> updateTerminovaListina(@PathVariable Long id, 
                                                                  @RequestBody TerminovaListina terminovaListina) {
        if (!terminovaListinaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        terminovaListina.setID(id);
        return ResponseEntity.ok(terminovaListinaService.save(terminovaListina));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerminovaListina(@PathVariable Long id) {
        if (!terminovaListinaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        terminovaListinaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}