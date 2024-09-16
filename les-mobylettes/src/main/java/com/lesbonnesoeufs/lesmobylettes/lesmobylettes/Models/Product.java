package com.lesbonnesoeufs.lesmobylettes.lesmobylettes.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "t_Product")
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
    private String DestinationStateCountry;

    @Column(length = 255)
    private String adress;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos = new ArrayList<>();
}

