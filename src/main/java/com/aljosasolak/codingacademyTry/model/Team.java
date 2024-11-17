package com.aljosasolak.codingacademyTry.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "teams")
public class Team {

    @Column(name = "team_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int teamId;
    private String teamName;
    private String officialTeamName;
    private String slug;
    private String abbreviation;
    private String teamCountryCode;
    private String stagePosition;
}
