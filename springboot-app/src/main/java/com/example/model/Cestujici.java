package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CESTUJICI")
@IdClass(CestujiciId.class)
public class Cestujici {
    private Integer pocetMist;
    @Enumerated(EnumType.ORDINAL)
    private Stav stav;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_uzivatel")
    private Uzivatel uzivatel;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_spolujizda")
    private Spolujizda spolujizda;

    public static enum Stav {
      PRIHLASENY, POTVRZENY, ZAMITNUTY, ZRUSENY
    }
}
