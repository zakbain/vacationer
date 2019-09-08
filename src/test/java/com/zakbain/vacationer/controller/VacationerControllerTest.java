package com.zakbain.vacationer.controller;

import com.zakbain.vacationer.repository.EventRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.mockito.Mockito.*;

public class VacationerControllerTest {
    @Mock
    private EventRepository mockEventRepository;
    @Mock
    private Iterable mockEvents;
    @Mock
    private Model mockModel;
    private VacationerController vacationerController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        vacationerController = new VacationerController(mockEventRepository);
    }

    @Test
    public void getLoginPage() {
        String login = vacationerController.login();
        Assert.assertEquals("login endpoint should return login page name", "login", login);
    }

    @Test
    public void getIndexPage() {
        when(mockEventRepository.findAll()).thenReturn(mockEvents);
        vacationerController.index(mockModel);
        verify(mockModel, times(1)).addAttribute("events", mockEvents);
    }
}
