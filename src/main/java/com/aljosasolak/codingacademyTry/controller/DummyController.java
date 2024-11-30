package com.aljosasolak.codingacademyTry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Dummy Controller used for the nav bar elements (WATCH, BET, TICKETS, RESULTS) that are not built yet and that are not in the focus of this coding challenge
@Controller
@RequestMapping({"/watch", "/bet", "/tickets", "/results"})
public class DummyController {

    @GetMapping("")
    public String getDummyController() {
    return "dummy";
    }
}
