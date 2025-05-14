package cz.bezcisobe.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.time.LocalDate;

@Data
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    
    @Column(unique = true)
    private String username;
    private String password;
    private Boolean isAdmin;
    @Column(unique = true)
    private String googleId;
    @Column(unique = true)
    private String facebookId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private String city;
    private LocalDate driversLicenseValidUntil;
    @Column(unique = true)
    private String driversLicenseId;
    private Boolean isBlocked;
    private String note;

    @OneToMany(mappedBy = "user")
    private List<RideRequest> rideRequests;


    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}