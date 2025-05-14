package cz.bezcisobe.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table
public class RideRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    
    private LocalDate departureDate;
    private String departureTime;
    private String depraturePlace;
    private Integer numSeats;
    private String note;

    @ManyToOne
    @JoinColumn(name = "ID_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ID_race")
    private Race race;

    public LocalDate getDepartureDate() {
      return departureDate;
    }

    public String getDepartureTime() {
      return departureTime;
    }

    public String getDepraturePlace() {
      return depraturePlace;
    }

    public Integer getNumSeats() {
      return numSeats;
    }

    public String getNote() {
      return note;
    }

    public void setDepartureDate(LocalDate departureDate) {
      this.departureDate = departureDate;
    }

    public void setDepartureTime (String departureTime) {
      this.departureTime = departureTime;
    }

    public void setDepraturePlace(String departurePlace) {
      this.depraturePlace = departurePlace;
    }

    public void setNumSeats(Integer numSeats) {
      this.numSeats = numSeats;
    }

    public void setNote(String note) {
      this.note = note;
    }
}