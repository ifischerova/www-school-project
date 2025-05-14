package cz.bezcisobe.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RideResponse {
    private Long id;
    private UserBriefDto driver;
    private RaceBriefDto race;
    private Integer seats;
    private Integer availableSeats;
    private String note;
    private String meetingPoint;
    private String meetingTime;
    private LocalDateTime created;

    @Data
    public static class UserBriefDto {
        private Long id;
        private String username;
    }

    @Data
    public static class RaceBriefDto {
        private Long id;
        private String name;
    }
}