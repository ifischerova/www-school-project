package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TERMINOVA_LISTINA")
public class TerminovaListina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private Integer rok;

    @ManyToOne
    @JoinColumn(name = "ID_zavod")
    private Zavod zavod;
}