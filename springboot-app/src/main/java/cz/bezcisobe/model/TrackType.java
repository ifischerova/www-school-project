package cz.bezcisobe.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class TrackType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
}