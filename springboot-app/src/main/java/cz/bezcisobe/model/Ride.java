package cz.bezcisobe.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private String departurePlace;
    private Integer numSeats;
    private String note;
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "ID_race")
    private Race race;

    @ManyToOne
    @JoinColumn(name = "ID_driver")
    private User driver;

    @ManyToMany
    private List<Passenger> passengers;

    
    public static enum Status {
      OPEN, REALIZED, CLOSED, CANCELED_BY_ADMIN, CANCELED_RACE, CANCELED_BY_DRIVER
    }
}