package org.example.hobbysplatform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Event {
    private String name;
    private String location;
    private String date;
    private String category;
    private boolean isPublic;
}