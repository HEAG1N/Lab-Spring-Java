package org.example.hobbysplatform.repository;

import org.example.hobbysplatform.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByCategory(String category);
    List<Event> findByIsPublic(boolean isPublic);
    List<Event> findByDateAfter(LocalDate date);
    List<Event> findByNameContainingIgnoreCase(String name);
}