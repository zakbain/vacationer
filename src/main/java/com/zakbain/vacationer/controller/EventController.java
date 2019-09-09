package com.zakbain.vacationer.controller;

import com.zakbain.vacationer.model.Event;
import com.zakbain.vacationer.repository.EventRepository;
import com.zakbain.vacationer.util.DefaultEventPopulater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class EventController {
    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/createEvent")
    public String createEvent(Event event)  {
        return "createEvent";
    }

    @PostMapping("/addEvent")
    public String addEvent(@Valid Event event, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "createEvent";
        }

        eventRepository.save(event);
        model.addAttribute("events", eventRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateEvent(@PathVariable("id") long id, Model model) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("event", event);
        return "updateEvent";
    }

    @PostMapping("/update/{id}")
    public String updateEvent(@PathVariable("id") long id, @Valid Event event, BindingResult result, Model model) {
        if (result.hasErrors()) {
            event.setId(id);
            return "updateEvent";
        }

        eventRepository.save(event);
        model.addAttribute("events", eventRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") long id, Model model) {
        Event event  = eventRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Event Id:" + id));
        eventRepository.delete(event);
        model.addAttribute("events", eventRepository.findAll());
        return "index";
    }

    @RequestMapping("/createDefaults")
    public String createDefaults(Model model) {
        //For demo purpose, quickly populate results
        new DefaultEventPopulater().populateEventRepository(eventRepository);
        model.addAttribute("events", eventRepository.findAll());
        return "index";
    }
}
