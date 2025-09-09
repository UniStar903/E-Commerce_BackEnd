package com.precize.e_commerce.controller;
import com.precize.e_commerce.events.Event;
import com.precize.e_commerce.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/events/data")
@RequiredArgsConstructor
public class EventController {

    private final EventService service;

    @GetMapping
    public String getAll() {
        return service.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventByID(@PathVariable String id) {
        return service.getEvent(id);
    }

    @PostMapping("/create")
    public Event create(@RequestBody Event event) {
        return service.saveEvent(event);
    }

    @DeleteMapping("/{id}")
    public String deleteEventByID(@PathVariable String id) {
        service.deleteEventById(id);
        return "Event deleted: " + id;
    }

}

