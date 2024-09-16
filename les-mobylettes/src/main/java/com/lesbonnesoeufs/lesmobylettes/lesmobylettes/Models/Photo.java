package com.lesbonnesoeufs.lesmobylettes.lesmobylettes.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data // Génère les getters, setters, toString(), equals(), et hashCode().
@NoArgsConstructor // Génère un constructeur sans argument.
@AllArgsConstructor  //Génère un constructeur avec tous les arguments.
@Entity
@Table(name = "t_Photo")

public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String title;

    @Column
    private LocalDate dateAdded;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;
}
