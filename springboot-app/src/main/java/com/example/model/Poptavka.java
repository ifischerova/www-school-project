package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "POPTAVKA")
public class Poptavka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    
    private LocalDateTime datumOdjezdu;
    private String casOdjezdu;
    private String mistoOdjezdu;
    private Integer pocetMist;
    private String poznamka;

    @ManyToOne
    @JoinColumn(name = "ID_uzivatel")
    private Uzivatel uzivatel;

    @ManyToOne
    @JoinColumn(name = "ID_zavod")
    private Zavod zavod;
}