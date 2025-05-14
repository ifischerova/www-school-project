package cz.bezcisobe.dto.request;

import lombok.Data;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class UpdateUserRequest {
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone number format")
    private String phone;

    @Size(max = 100, message = "City name cannot exceed 100 characters")
    private String city;

    @Future(message = "Driver's license must be valid in the future")
    private LocalDate driversLicenseValidUntil;

    @Size(max = 50, message = "Driver's license ID cannot exceed 50 characters")
    private String driversLicenseId;

    @Size(max = 500, message = "Note cannot exceed 500 characters")
    private String note;
}
