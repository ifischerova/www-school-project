package cz.bezcisobe.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.service.CertificationService;
import cz.bezcisobe.dto.request.CreateCertificationRequest;
import cz.bezcisobe.dto.response.CertificationResponse;
import cz.bezcisobe.dto.response.CertificationListResponse;

@RestController
@RequestMapping("/api/certification")
public class CertificationController {
    @Autowired
    private CertificationService certificationService;

    @GetMapping
    public CertificationListResponse getAllCertifications() {
        return certificationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CertificationResponse> getCertificationById(@PathVariable Long id) {
        return certificationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CertificationResponse createCertification(@Valid @RequestBody CreateCertificationRequest request) {
        return certificationService.create(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CertificationResponse> updateCertification(
            @PathVariable Long id,
            @Valid @RequestBody CreateCertificationRequest request) {
        return certificationService.update(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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