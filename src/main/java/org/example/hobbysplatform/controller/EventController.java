package org.example.hobbysplatform.controller;

import lombok.RequiredArgsConstructor;
import org.example.hobbysplatform.model.Event;
import org.example.hobbysplatform.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return eventService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.save(event));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return ResponseEntity.ok(eventService.update(id, event));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Event> partialUpdateEvent(@PathVariable Long id, @RequestBody Event event) {
        Event currentEvent = eventService.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));

        // Only update non-null fields
        if (event.getName() != null) {
            currentEvent.setName(event.getName());
        }
        if (event.getLocation() != null) {
            currentEvent.setLocation(event.getLocation());
        }
        if (event.getDate() != null) {
            currentEvent.setDate(event.getDate());
        }
        if (event.getCategory() != null) {
            currentEvent.setCategory(event.getCategory());
        }

        return ResponseEntity.ok(eventService.save(currentEvent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
