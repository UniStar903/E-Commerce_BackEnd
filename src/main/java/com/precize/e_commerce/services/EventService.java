package com.precize.e_commerce.services;

import com.precize.e_commerce.events.Event;
import com.precize.e_commerce.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public String getAllEvents() {
        return eventRepository.findAll().toString();
    }

    public Event getEvent(@PathVariable String id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found: " + id));
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event findEventById(String id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found: " + id));
    }

    public void deleteEventById(String id) {
        eventRepository.deleteById(id);
    }

}
