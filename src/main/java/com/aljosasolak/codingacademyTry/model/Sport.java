package com.aljosasolak.codingacademyTry.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sports")
public class Sport {

    @Column(name = "sport_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int sportId;
    private String sport;
}
