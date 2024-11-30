package com.aljosasolak.codingacademyTry.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventCreateResource {
    @NotNull(message = "The season is required")
    private Integer season;
    @NotBlank(message = "The status is required")
    private String status;
    @NotBlank(message = "The time is required")
    private String timeVenueUTCString;
    @NotBlank(message = "The date is required")
    private String dateVenueString;
    @NotNull(message = "The venue is required")
    private Integer venueId;
    @NotNull(message = "The sport is required")
    private Integer sportId;
    @NotNull(message = "The home team name is required")
    private Integer homeTeamId;
    @NotNull(message = "The away team name is required")
    private Integer awayTeamId;
    @NotNull(message = "The stage is required")
    private Integer stageId;
    @NotNull(message = "The online availability is required")
    private Integer onlineAvailable;
    @NotNull(message = "The ticket availability is required")
    private Integer ticketsAvailable;

    private LocalDateTime timeVenueUTC;
    private LocalDateTime dateVenue;
}
