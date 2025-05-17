package cz.bezcisobe.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;
    
    private String name;
    private String place;
    private LocalDate date;
    private String startTime;
    private String web;

    @ManyToOne
    @JoinColumn(name = "ID_trackLength")
    private TrackLength trackLength;

    @ManyToOne
    @JoinColumn(name = "ID_trackType")
    private TrackType trackType;

    @ManyToMany
    @JoinTable(name = "RaceCertification", joinColumns = @JoinColumn(name = "ID_race"), inverseJoinColumns = @JoinColumn(name = "ID_certification"))
    private List<Certification> certification;

    @ManyToOne
    @JoinColumn(name = "ID_race_calendar")
    private RaceCalendar raceCalendar;

    @OneToMany(mappedBy = "race")
    private List<RideRequest> rideRequests;

    @OneToMany(mappedBy = "race")
    private List<Ride> rides;
}