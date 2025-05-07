package org.example.hobbysplatform;

import org.example.hobbysplatform.model.Event;
import org.example.hobbysplatform.model.Group;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Event event(){
        return new Event("Utopia","PortMall","21-01-2025","Muzica",true);
    }
    @Bean
    public Group group(){
        return new Group("Titlu","descriptie",23,false,"Hobbytag");
    }
}
