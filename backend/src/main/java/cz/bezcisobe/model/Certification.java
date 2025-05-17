package cz.bezcisobe.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;
    
    private String name;

    @ManyToMany(mappedBy = "certification")
    private List<Race> races;
}