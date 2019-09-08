package com.zakbain.vacationer.util;

import com.zakbain.vacationer.model.Event;
import com.zakbain.vacationer.repository.EventRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DefaultEventPopulater {
    // If the Event Repository is empty, add some default values (locations in St. Petersburg)
    public void populateEventRepository(EventRepository eventRepository) {
        Iterable<Event> events = eventRepository.findAll();
        if (!events.iterator().hasNext()) {
            List<Event> defaultEvents = new ArrayList<>();
            defaultEvents.add(new Event("Mariinsky Theatre", "Swan Lake", new GregorianCalendar(2019, 9, 20, 8, 0, 0).getTime(), false));
            defaultEvents.add(new Event("State Hermitage Museum", "Art Museum", null, false));
            defaultEvents.add(new Event("Peterhof Palace", "Royal Palace", null, true));
            defaultEvents.add(new Event("Ukrop", "Vegan Friendly Cafe", null, false));
            eventRepository.saveAll(defaultEvents);
        }
    }
}
