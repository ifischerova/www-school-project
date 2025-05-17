package cz.bezcisobe.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cz.bezcisobe.service.CertificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import cz.bezcisobe.dto.request.CreateCertificationRequest;
import cz.bezcisobe.dto.response.CertificationResponse;
import cz.bezcisobe.dto.response.CertificationListResponse;

@RestController
@RequestMapping("/api/certification")
@Tag(name = "Certification", description = "Certification management APIs")
public class CertificationController {
    @Autowired
    private CertificationService certificationService;
 
    @Operation(
        summary = "Get all certifications",
        description = "Returns a list of all certifications"
    )
    @ApiResponse(responseCode = "200", description = "Found the certifications")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Certifications not found")
    @GetMapping
    public CertificationListResponse getAllCertifications() {
        return certificationService.findAll();
    }

    @Operation(
        summary = "Get a certification by ID",
        description = "Returns a certification based on the ID"
    )
    @ApiResponse(responseCode = "200", description = "Found the certification")
    @ApiResponse(responseCode = "404", description = "Certification not found")
    @GetMapping("/{id}")
    public ResponseEntity<CertificationResponse> getCertificationById(@PathVariable Long id) {
        return certificationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Create a new certification",
        description = "Creates a new certification with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Certification created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @PostMapping
    public CertificationResponse createCertification(@Valid @RequestBody CreateCertificationRequest request) {
        return certificationService.create(request);
    }

    @Operation(
        summary = "Update an existing certification",
        description = "Updates an existing certification with the provided details"
    )
    @ApiResponse(responseCode = "200", description = "Certification updated successfully")
    @ApiResponse(responseCode = "404", description = "Certification not found")
    @ApiResponse(responseCode = "400", description = "Invalid input")    
    @PutMapping("/{id}")
    public ResponseEntity<CertificationResponse> updateCertification(
            @PathVariable Long id,
            @Valid @RequestBody CreateCertificationRequest request) {
        return certificationService.update(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Delete a certification",
        description = "Deletes certification."
    )
    @ApiResponse(responseCode = "204", description = "Certification deleted.")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "404", description = "Certification not found.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertification(@PathVariable Long id) {
        if (!certificationService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        certificationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}