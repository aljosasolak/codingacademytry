package com.aljosasolak.codingacademyTry.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int eventId;
    private int season;
    private String status;
    private LocalDateTime timeVenueUTC;
    private LocalDateTime dateVenue;

    @Column(name = "venue_id", insertable = false, updatable = false)
    private int venueId;
    @ManyToOne
    @JoinColumn(name = "venue_id", referencedColumnName = "VenueId")
    private Venue venue;

    @Column(name = "sport_id", insertable = false, updatable = false)
    private int sportId;
    @ManyToOne
    @JoinColumn(name = "sport_id", referencedColumnName = "sport_id")
    private Sport sport;

    @Column(name = "team_id", insertable=false, updatable=false)
    private int homeTeamId;
    @ManyToOne
    @JoinColumn(name = "home_team_id", referencedColumnName = "team_id")
    private Team homeTeam;

    @Column(name = "away_team_id", insertable=false, updatable=false)
    private int awayTeamId;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private Team awayTeam;

    @OneToOne(cascade = CascadeType.ALL)
    private Result result;

    @Column(name = "stage_id", insertable = false, updatable = false)
    private int stageId;
    @ManyToOne
    @JoinColumn(name = "stage_id", referencedColumnName = "stage_id")
    private Stage stage;
    private int TeamGroup;
    private String OriginCompetitionId;
    private String OriginCompetitionName;
    private boolean OnlineAvailable;
    private boolean TicketsAvailable;


}
