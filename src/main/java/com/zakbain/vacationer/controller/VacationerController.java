package com.zakbain.vacationer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VacationerController {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping({ "/index", "/" })
    public String index() {
        return "index";
    }
}

