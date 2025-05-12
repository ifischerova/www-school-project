package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "CERTIFIKACE")
public class Certifikace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    
    private String nazev;

    @ManyToMany(mappedBy = "certifikace")
    private List<Zavod> zavody;
}