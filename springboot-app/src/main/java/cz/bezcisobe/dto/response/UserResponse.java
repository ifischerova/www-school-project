package cz.bezcisobe.dto.response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String city;
    private LocalDate driversLicenseValidUntil;
    private String driversLicenseId;
    private Boolean isBlocked;
    private Boolean isAdmin;
    private String note;
}