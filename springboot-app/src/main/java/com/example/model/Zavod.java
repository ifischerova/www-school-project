package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "ZAVOD")
public class Zavod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    
    private String nazev;
    private String mistoKonani;
    private LocalDate datumKonani;
    private String casKonani;
    private String web;

    @ManyToOne
    @JoinColumn(name = "ID_delkaTrate")
    private DelkaTrate delkaTrate;

    @ManyToOne
    @JoinColumn(name = "ID_druhTrate")
    private DruhTrate druhTrate;

    @ManyToMany
    @JoinTable(name = "ZAVOD_CERTIFIKACE", joinColumns = @JoinColumn(name = "ID_zavod"), inverseJoinColumns = @JoinColumn(name = "ID_certifikace"))
    private List<Certifikace> certifikace;

    @ManyToOne
    @JoinColumn(name = "ID_terminova_listina")
    private TerminovaListina terminovaListina;

    @OneToMany(mappedBy = "zavod")
    private List<Poptavka> poptavky;

    @OneToMany(mappedBy = "zavod")
    private List<Spolujizda> spolujizdy;
}