package cz.bezcisobe.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class TrackLength {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
}