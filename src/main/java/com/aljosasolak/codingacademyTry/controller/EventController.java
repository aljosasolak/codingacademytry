package com.aljosasolak.codingacademyTry.controller;

import com.aljosasolak.codingacademyTry.model.*;
import com.aljosasolak.codingacademyTry.repository.SportRepository;
import com.aljosasolak.codingacademyTry.repository.StageRepository;
import com.aljosasolak.codingacademyTry.repository.TeamRepository;
import com.aljosasolak.codingacademyTry.repository.VenueRepository;
import com.aljosasolak.codingacademyTry.resource.EventCreateResource;
import com.aljosasolak.codingacademyTry.resource.EventResource;
import com.aljosasolak.codingacademyTry.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private final EventService eventService;
    @Autowired
    private final VenueRepository venueRepository;
    @Autowired
    private final SportRepository sportRepository;
    @Autowired
    private final TeamRepository teamRepository;
    @Autowired
    private final StageRepository stageRepository;

    public EventController(EventService eventService, VenueRepository venueRepository, SportRepository sportRepository, TeamRepository teamRepository, StageRepository stageRepository) {
        this.eventService = eventService;
        this.venueRepository = venueRepository;
        this.sportRepository = sportRepository;
        this.teamRepository = teamRepository;
        this.stageRepository = stageRepository;
    }

    //Get all events from the database and populate the event table
    @GetMapping({"", "/"})
    public String getEvents(Model model) {
        List<EventResource> events = eventService.getEvents();
        model.addAttribute("events", events);
        return "/events/index";
    }

    //Mathod to bind the create event form with the model and to show the form in the thymeleaf frontend
    @GetMapping("/create")
    public String createEvent(Model model) {
        EventCreateResource eventCreateResource = new EventCreateResource();
        model.addAttribute("eventCreateResource", eventCreateResource);

        populateDropdowns(model);

        return "/events/create";
    }

    //Create method to validate and persist the new data in the database
    @PostMapping("/create")
    public String createEvent(@Valid @ModelAttribute EventCreateResource eventCreateResource, BindingResult result, Model model) {
        if (result.hasErrors()) {
            populateDropdowns(model);
            return "/events/create";
        }

        if (eventCreateResource.getHomeTeamId().equals(eventCreateResource.getAwayTeamId())) {
            result.addError(
                    new FieldError("eventCreateResource", "awayTeamId",
                            "One team cannot play against itself, you silly! :)")
            );
            populateDropdowns(model);
            return "/events/create";
        }

        eventService.createEvent(eventCreateResource);
        return eventService.getEventServiceResult();
    }

    //Delete method to remove a sport event from the list
    @GetMapping("/delete")
    public String deleteEvent(@RequestParam int id) {
        eventService.deleteEvent(id);
        return "redirect:/events";
    }

    //Sort the dropdown entries in the create event form
    public Sort sortAscending(String SortBy) {
        return Sort.by(Sort.Direction.ASC, SortBy);
    }

    //Method to populate the dropdowns in the form to create a sport event
    public void populateDropdowns(Model model) {
        List<Venue> venues = venueRepository.findAll(sortAscending("venueName"));
        model.addAttribute("venues", venues);

        List<Sport> sports = sportRepository.findAll(sortAscending("sport"));
        model.addAttribute("sports", sports);

        List<Team> teams = teamRepository.findAll(sortAscending("teamName"));
        model.addAttribute("teams", teams);

        List<Stage> stages = stageRepository.findAll();
        model.addAttribute("stages", stages);
    }
}
