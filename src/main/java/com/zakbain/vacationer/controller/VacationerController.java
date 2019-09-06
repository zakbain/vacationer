package com.zakbain.vacationer.controller;

import com.zakbain.vacationer.repository.EventRepository;
import com.zakbain.vacationer.util.EventPopulater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VacationerController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping({ "/index", "/" })
    public String index(Model model) {

        model.addAttribute("events", eventRepository.findAll());
        return "index";
    }

    @RequestMapping("/createDefaults")
    public String createDefaults(Model model) {
        new EventPopulater().populateEventRepository(eventRepository);
        model.addAttribute("events", eventRepository.findAll());
        return "index";
    }
}

