package cz.bezcisobe.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CreateRideRequestRequest {
    @NotNull(message = "Race ID is required")
    private Long raceId;

    @Size(max = 500, message = "Note cannot exceed 500 characters")
    private String note;
    
    @NotNull(message = "Number of seats is required")
    @Min(value = 1, message = "Minimum 1 seat required")
    @Max(value = 8, message = "Maximum 8 seats allowed")
    private Integer seatsRequested; 
}