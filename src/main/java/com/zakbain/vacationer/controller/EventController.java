package com.zakbain.vacationer.controller;

import com.zakbain.vacationer.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public Iterable findAll() {
        return eventRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public List findByUser(@PathVariable long userId) {
        return eventRepository.findByUserId(userId);
    }

}
