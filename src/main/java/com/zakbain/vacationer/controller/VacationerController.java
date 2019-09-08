package com.zakbain.vacationer.controller;

import com.zakbain.vacationer.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VacationerController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping({"/index", "/"})
    public String index(Model model) {

        model.addAttribute("events", eventRepository.findAll());
        return "index";
    }
}

