package cz.bezcisobe.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class PassengerId implements Serializable {
    @Column(name = "ID_user")
    private Long user;
    
    @Column(name = "ID_ride")
    private Long ride;
}