package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class CestujiciId implements Serializable {
    @Column(name = "ID_uzivatel")
    private Long uzivatel;
    
    @Column(name = "ID_spolujizda")
    private Long spolujizda;
}