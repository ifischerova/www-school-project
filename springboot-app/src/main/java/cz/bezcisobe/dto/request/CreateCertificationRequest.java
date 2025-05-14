package cz.bezcisobe.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateCertificationRequest {
    @NotBlank(message = "Certification name is required")
    @Size(min = 2, max = 100, message = "Certification name must be between 2 and 100 characters")
    private String name;
}