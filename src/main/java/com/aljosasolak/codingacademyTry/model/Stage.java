package com.aljosasolak.codingacademyTry.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "stages")
public class Stage {

    @Column(name = "stage_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stageId;
    private String stageName;
    private int ordering;
}
