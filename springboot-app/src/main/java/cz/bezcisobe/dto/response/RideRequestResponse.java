package cz.bezcisobe.dto.response;

import lombok.Data;

@Data
public class RideRequestResponse {
    private Long id;
    private UserBriefDto requester;
    private RaceBriefDto race;
    private Integer seatsRequested;
    private String note;

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