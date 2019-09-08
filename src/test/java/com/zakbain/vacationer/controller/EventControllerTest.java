package com.zakbain.vacationer.controller;

import com.zakbain.vacationer.controller.EventController;
import com.zakbain.vacationer.model.Event;
import com.zakbain.vacationer.repository.EventRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import static org.mockito.Mockito.times;

import java.util.Date;

public class EventControllerTest {
    @Mock
    private EventRepository mockEventRepository;
    @Mock
    private BindingResult mockBindingResult;
    @Mock
    private Model mockModel;
    private EventController eventController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        eventController = new EventController(mockEventRepository);
    }

    @Test
    public void addValidEvent() {
        Event event = new Event("location", "description", new Date(), false);
        eventController.addEvent(event, mockBindingResult, mockModel);
        Mockito.verify(mockEventRepository, times(1)).save(event);
    }
}
