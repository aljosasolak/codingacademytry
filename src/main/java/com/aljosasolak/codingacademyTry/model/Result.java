package com.aljosasolak.codingacademyTry.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int resultId;
    private int homeGoals;
    private int awayGoals;
    private String winner;
}
