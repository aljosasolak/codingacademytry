package com.aljosasolak.codingacademyTry.service;

import com.aljosasolak.codingacademyTry.mapper.MapperImpl;
import com.aljosasolak.codingacademyTry.model.*;
import com.aljosasolak.codingacademyTry.repository.*;
import com.aljosasolak.codingacademyTry.resource.EventCreateResource;
import com.aljosasolak.codingacademyTry.resource.EventResource;
import lombok.Data;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Service
@Data
public class EventService {

    private String eventServiceResult;

    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;
    private final SportRepository sportRepository;
    private final TeamRepository teamRepository;
    private final StageRepository stageRepository;
    private final MapperImpl mapper;

    public EventService(EventRepository eventRepository, VenueRepository venueRepository, SportRepository sportRepository, TeamRepository teamRepository, StageRepository stageRepository, MapperImpl mapper) {
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
        this.sportRepository = sportRepository;
        this.teamRepository = teamRepository;
        this.stageRepository = stageRepository;
        this.mapper = mapper;
    }

    public List<EventResource> getEvents() {
        Sort sort = Sort.by(Sort.Direction.DESC, "dateVenue", "timeVenueUTC");
        return mapper.mapList(eventRepository.findAll(sort), EventResource.class);
    }

    public String createEvent(EventCreateResource eventCreateResource) {

        eventCreateResource.setTimeVenueUTC(timeConverter(eventCreateResource.getTimeVenueUTCString()));
        eventCreateResource.setDateVenue(dateConverter(eventCreateResource.getDateVenueString()));

        Event entity = mapper.map(eventCreateResource, Event.class);
        entity.setVenue(venueRepository.findById(eventCreateResource.getVenueId()).orElse(null));
        entity.setSport(sportRepository.findById(eventCreateResource.getSportId()).orElse(null));
        entity.setHomeTeam(teamRepository.findById(eventCreateResource.getHomeTeamId()).orElse(null));
        entity.setAwayTeam(teamRepository.findById(eventCreateResource.getAwayTeamId()).orElse(null));
        entity.setStage(stageRepository.findById(eventCreateResource.getStageId()).orElse(null));

        eventRepository.save(entity);

        eventServiceResult = "redirect:/events";
        return eventServiceResult;
    }


    public void deleteEvent(int id) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event != null) {
            eventRepository.delete(event);
        }
    }

    //Utility methods
    private LocalDateTime dateConverter (String stringInput) {
        stringInput = stringInput + " 00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(stringInput, formatter);
    }
    private LocalDateTime timeConverter (String stringInput) {
        stringInput = LocalDate.now().toString() + " " + stringInput;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(stringInput, formatter);
    }

}
