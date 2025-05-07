package org.example.hobbysplatform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Group {
    private String title;
    private String description;
    private int membersCount;
    private boolean openGroup;
    private String hobbyTag;
}