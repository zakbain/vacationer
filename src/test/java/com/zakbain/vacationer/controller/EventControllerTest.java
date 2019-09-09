package com.zakbain.vacationer.controller;

import com.zakbain.vacationer.controller.EventController;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

public class EventControllerTest {
    private static final String INDEX = "index";
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
        String addSuccessPage = eventController.addEvent(event, mockBindingResult, mockModel);
        Mockito.verify(mockEventRepository, times(1)).save(event);
        Assert.assertEquals("After add, return to index", INDEX, addSuccessPage);
    }

    @Test
    public void addEventWithErrorsFail() {
        when(mockBindingResult.hasErrors()).thenReturn(true);
        Event event = new Event("location", "description", new Date(), false);
        String addFailPage = eventController.addEvent(event, mockBindingResult, mockModel);
        Mockito.verify(mockEventRepository, times(0)).save(event);
        Assert.assertEquals("After add failed, return to add event", "createEvent", addFailPage);
    }

    @Test
    public void updateValidEvent() {
        Event event = new Event("location", "description", new Date(), false);
        event.setId(0);
        String updateSuccessPage =  eventController.updateEvent(0, event, mockBindingResult, mockModel);
        Mockito.verify(mockEventRepository, times(1)).save(event);
        Assert.assertEquals("After update, return to index", INDEX, updateSuccessPage);
    }

    @Test
    public void deleteEvent() {
        Event event = new Event("location", "description", new Date(), false);
        when(mockEventRepository.findById(0l)).thenReturn( Optional.of(event));
        String afterDeletePage = eventController.deleteEvent(0, mockModel);
        Mockito.verify(mockEventRepository, times(1)).delete(event);
        Mockito.verify(mockModel, times(1)).addAttribute(Mockito.any(), Mockito.any());
        Assert.assertEquals("After delete, return to index", INDEX, afterDeletePage);
    }

    @Test (expected = IllegalArgumentException.class)
    public void deleteEventErrorsThrowException() {
        Event event = new Event("location", "description", new Date(), false);
        when(mockEventRepository.findById(0l)).thenReturn(Optional.of(event));
        eventController.deleteEvent(1, mockModel);
    }
}
