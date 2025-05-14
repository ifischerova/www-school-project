package cz.bezcisobe.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class RaceCalendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private Integer year;

    @ManyToOne
    @JoinColumn(name = "ID_race")
    private Race race;
}