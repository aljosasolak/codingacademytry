package com.aljosasolak.codingacademyTry.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "venues")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int venueId;

    private String venueName;

}
