package cz.bezcisobe.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CreateRideRequest {
    @NotNull(message = "Race ID is required")
    private Long raceId;

    @NotNull(message = "Number of seats is required")
    @Min(value = 1, message = "Minimum 1 seat required")
    @Max(value = 8, message = "Maximum 8 seats allowed")
    private Integer seats;

    @Size(max = 500, message = "Note cannot exceed 500 characters")
    private String note;

    @NotNull(message = "Meeting point is required")
    @Size(max = 100, message = "Meeting point cannot exceed 100 characters")
    private String meetingPoint;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Invalid time format (HH:mm)")
    private String meetingTime;
}