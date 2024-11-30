package com.aljosasolak.codingacademyTry.resource;

import com.aljosasolak.codingacademyTry.model.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class EventResource {

    private int eventId;
    private LocalDateTime timeVenueUTC;
    private LocalDateTime dateVenue;
    private Venue venue;
    private Sport sport;
    private Team homeTeam;
    private Team awayTeam;
    private Stage stage;
    private int onlineAvailable;
    private int ticketsAvailable;

}
