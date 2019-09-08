package com.zakbain.vacationer.controller;

import com.zakbain.vacationer.model.Event;
import com.zakbain.vacationer.repository.EventRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class EventRestControllerTest {
    @Mock
    private EventRepository mockEventRepository;
    @Mock
    private Model mockModel;
    private EventRestController eventRestController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        eventRestController = new EventRestController(mockEventRepository);
    }

    @Test
    public void addValidEvent() {
        Event event1 = new Event("location1", "description2", new Date(), false);
        Event event2 = new Event("location2", "description2", new Date(), false);
        List<Event> eventsInRepo = new ArrayList<>();
        eventsInRepo.add(event1);
        eventsInRepo.add(event2);
        when(mockEventRepository.findAll()).thenReturn(eventsInRepo);
        List<Event> eventsFromRest = (List<Event>) eventRestController.getAllEvents();
        Assert.assertEquals("Events from rest controller must match events in repository", eventsInRepo, eventsFromRest);
    }
}
