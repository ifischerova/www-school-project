package cz.bezcisobe.dto.response;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class RaceResponse {
    private Long id;
    private String name;
    private String place;
    private LocalDate date;
    private String startTime;
    private String web;
    private TrackLengthDto trackLength;
    private TrackTypeDto trackType;
    private List<CertificationDto> certifications;
    private RaceCalendarDto raceCalendar;

    @Data
    public static class TrackLengthDto {
        private Long id;
        private String name;
    }

    @Data
    public static class TrackTypeDto {
        private Long id;
        private String name;
    }

    @Data
    public static class CertificationDto {
        private Long id;
        private String name;
    }

    @Data
    public static class RaceCalendarDto {
        private Long id;
        private Integer year;
    }
}