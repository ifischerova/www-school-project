package cz.bezcisobe.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PassengerResponse {
    private Long rideId;
    private Long userId;
    private String username;
    private Integer seats;
    private LocalDateTime joinedAt;
}