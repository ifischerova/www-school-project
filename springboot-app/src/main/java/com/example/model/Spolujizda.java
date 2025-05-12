package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "SPOLUJIZDA")
public class Spolujizda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private LocalDate datumOdjezdu;
    private LocalTime casOdjezdu;
    private String MistoOdjezdu;
    private Integer PocetMist;
    private String poznamka;
    @Enumerated(EnumType.ORDINAL)
    private Stav stav;

    @ManyToOne
    @JoinColumn(name = "ID_zavod")
    private Zavod zavod;

    @ManyToOne
    @JoinColumn(name = "ID_ridic")
    private Uzivatel ridic;

    @ManyToMany
    private List<Cestujici> cestujici;

    
    public static enum Stav {
      OTEVRENA, REALIZOVANA, ZAVRENA, ZRUSENA_ADMIN, ZRUSENA_ZAVOD, ZRUSENA_RIDICEM
    }
}