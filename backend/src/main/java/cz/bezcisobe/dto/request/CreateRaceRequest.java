package cz.bezcisobe.dto.request;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Future;

import java.time.LocalDate;
import java.util.List;

@Data
public class CreateRaceRequest {
    @NotBlank(message = "Race name is required")
    @Size(max = 100, message = "Race name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Place is required")
    @Size(max = 100, message = "Place name cannot exceed 100 characters")
    private String place;

    @NotNull(message = "Date is required")
    @Future(message = "Race date must be in the future")
    private LocalDate date;

    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "Invalid time format (HH:mm)")
    private String startTime;

    private String web;

    @NotNull(message = "Track length is required")
    private Long trackLengthId;

    @NotNull(message = "Track type is required")
    private Long trackTypeId;

    private List<Long> certificationIds;

    @NotNull(message = "Race calendar is required")
    private Long raceCalendarId;
}