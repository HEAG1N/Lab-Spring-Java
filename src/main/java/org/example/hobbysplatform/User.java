package org.example.hobbysplatform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@RequiredArgsConstructor
public class User {
    private String username;
    private String email;
    private int age;
    private String hobby;
    private boolean active;
    private Event event;
    private Group group;

    @Autowired
    public User(Event event, Group group) {
        this.event = event;
        this.group = group;
    }

    // Setter injection
    @Autowired
    public void setGroup(Group group) {
        this.group = group;
    }
    @Autowired
    public void setEvent(Event event) {
        this.event = event;
    }
}