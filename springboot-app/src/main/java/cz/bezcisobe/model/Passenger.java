package cz.bezcisobe.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
@IdClass(PassengerId.class)
public class Passenger {
    private Integer numSeats;
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_user")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_ride")
    private Ride ride;

    public static enum Status {
      RIDE_REQUESTED, CONFIRMED, REJECTED, CANCELED
    }
}
