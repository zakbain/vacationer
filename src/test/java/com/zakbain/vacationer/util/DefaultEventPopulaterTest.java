package com.zakbain.vacationer.util;

import com.zakbain.vacationer.repository.EventRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;

import static org.mockito.Mockito.*;

public class DefaultEventPopulaterTest {
    @Mock
    private EventRepository mockEventRepository;
    @Mock
    private Iterable mockEvents;
    @Mock
    private Iterator mockEventsIterator;
    private DefaultEventPopulater defaultEventPopulater;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        defaultEventPopulater = new DefaultEventPopulater();
    }

    @Test
    public void populateDefaultEventsIntoEmpty() {
        when(mockEventRepository.findAll()).thenReturn(mockEvents);
        when(mockEvents.iterator()).thenReturn(mockEventsIterator);
        when(mockEventsIterator.hasNext()).thenReturn(false);
        defaultEventPopulater.populateEventRepository(mockEventRepository);
        verify(mockEventRepository, times(1)).saveAll(Mockito.any());
    }

    @Test
    public void populateDefaultEventsIntoNonEmpty() {
        when(mockEventRepository.findAll()).thenReturn(mockEvents);
        when(mockEvents.iterator()).thenReturn(mockEventsIterator);
        when(mockEventsIterator.hasNext()).thenReturn(true);
        defaultEventPopulater.populateEventRepository(mockEventRepository);
        verify(mockEventRepository, times(0)).saveAll(Mockito.any());
    }
}
