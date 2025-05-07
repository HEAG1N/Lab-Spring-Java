package org.example.hobbysplatform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @Min(value = 0, message = "Members count cannot be negative")
    private int membersCount;

    private boolean openGroup;

    @NotBlank(message = "Hobby tag is required")
    private String hobbyTag;

    // Constructor without id for creating new groups
    public Group(String title, String description, int membersCount, boolean openGroup, String hobbyTag) {
        this.title = title;
        this.description = description;
        this.membersCount = membersCount;
        this.openGroup = openGroup;
        this.hobbyTag = hobbyTag;
    }
}