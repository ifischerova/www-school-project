package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.model.Certification;
import cz.bezcisobe.service.CertificationService;

import java.util.List;

@RestController
@RequestMapping("/api/certification")
public class CertificationController {
    @Autowired
    private CertificationService certificationService;

    @GetMapping
    public List<Certification> getAllCertifications() {
        return certificationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certification> getCertificationById(@PathVariable Long id) {
        return certificationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Certification createCertification(@RequestBody Certification certification) {
        return certificationService.save(certification);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Certification> updateCertification(@PathVariable Long id, 
                                                           @RequestBody Certification certification) {
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