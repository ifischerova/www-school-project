package com.example.controller;

import com.example.model.Certifikace;
import com.example.service.CertifikaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certifications")
public class CertifikaceController {
    @Autowired
    private CertifikaceService certificationService;

    @GetMapping
    public List<Certifikace> getAllCertifications() {
        return certificationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certifikace> getCertificationById(@PathVariable Long id) {
        return certificationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Certifikace createCertification(@RequestBody Certifikace certification) {
        return certificationService.save(certification);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Certifikace> updateCertification(@PathVariable Long id, 
                                                           @RequestBody Certifikace certification) {
        if (!certificationService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        certification.setID(id);
        return ResponseEntity.ok(certificationService.save(certification));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertification(@PathVariable Long id) {
        if (!certificationService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        certificationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}