package org.example.hobbysplatform.service;

import lombok.RequiredArgsConstructor;
import org.example.hobbysplatform.model.Event;
import org.example.hobbysplatform.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public Event update(Long id, Event eventDetails) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));

        existingEvent.setName(eventDetails.getName());
        existingEvent.setLocation(eventDetails.getLocation());
        existingEvent.setDate(eventDetails.getDate());
        existingEvent.setCategory(eventDetails.getCategory());
        existingEvent.setPublic(eventDetails.isPublic());

        return eventRepository.save(existingEvent);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> findByCategory(String category) {
        return eventRepository.findByCategory(category);
    }

    public List<Event> findByIsPublic(boolean isPublic) {
        return eventRepository.findByIsPublic(isPublic);
    }

    public List<Event> findUpcomingEvents() {
        return eventRepository.findByDateAfter(LocalDate.now());
    }
}
