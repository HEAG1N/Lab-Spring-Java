package org.example.hobbysplatform;

import org.example.hobbysplatform.model.Event;
import org.example.hobbysplatform.model.Group;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class AppConfig {
    @Bean
    public Event event() {
        return new Event("Utopia", "PortMall", LocalDate.of(2025, 1, 21), "Muzica", true);
    }

    @Bean
    public Group group() {
        return new Group("Titlu", "descriptie", 23, false, "Hobbytag");
    }
}