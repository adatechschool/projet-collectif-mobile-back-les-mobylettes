package com.lesbonnesoeufs.lesmobylettes.lesmobylettes.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String surfBreak;

    private int difficultyLevel;

    @Column(length = 255)
    private String destination;

    @Lob
    private String geocode;

    private Date peakSurfSeasonBegins;
    private Date peakSurfSeasonEnds;

    @Column(length = 255)
    private String destinationStateCountry;

    @Column(length = 255)
    private String address;  // Corrigé de 'adress' à 'address'

    @Column(length = 2048)
    private String photoUrl;
}
