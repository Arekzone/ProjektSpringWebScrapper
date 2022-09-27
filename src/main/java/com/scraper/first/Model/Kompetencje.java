package com.scraper.first.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "kompetencje")
public class Kompetencje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nazwa;



}
