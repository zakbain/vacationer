package com.zakbain.vacationer.controller;

import com.zakbain.vacationer.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventRestController {
    private final EventRepository eventRepository;

    @Autowired
    public EventRestController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/all")
    public Iterable getAllEvents() {
        return eventRepository.findAll();
    }
}
