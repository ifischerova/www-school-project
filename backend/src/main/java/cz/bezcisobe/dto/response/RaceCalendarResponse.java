package cz.bezcisobe.dto.response;

import lombok.Data;

@Data
public class RaceCalendarResponse {
    private Long id;
    private Integer year;
    private Boolean isActive;
}