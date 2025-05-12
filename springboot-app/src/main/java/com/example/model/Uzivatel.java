package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "UZIVATEL")
public class Uzivatel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    
    @Column(unique = true)
    private String uzivatelskeJmeno;
    private String heslo;
    private Boolean jeAdmin;
    @Column(unique = true)
    private String googleId;
    @Column(unique = true)
    private String facebookId;
    private String jmeno;
    private String prijmeni;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String telefon;
    private String mesto;
    private Boolean platnostRidicskehoPrukazu;
    @Column(unique = true)
    private String cisloRidicskehoPrukazu;
    private Boolean jeBlokovan;
    private String poznamka;

    @OneToMany(mappedBy = "uzivatel")
    private List<Poptavka> poptavky;
}