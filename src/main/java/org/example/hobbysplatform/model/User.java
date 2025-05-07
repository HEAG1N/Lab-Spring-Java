package org.example.hobbysplatform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(unique = true)
    private String email;

    @Min(value = 0, message = "Age cannot be negative")
    private int age;

    private String hobby;

    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    private Group group;

    // Constructor without id for creating new users
    public User(String username, String email, int age, String hobby, boolean active, Event event, Group group) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.hobby = hobby;
        this.active = active;
        this.event = event;
        this.group = group;
    }

    // Constructor without relationships for simpler user creation
    public User(String username, String email, int age, String hobby, boolean active) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.hobby = hobby;
        this.active = active;
    }
}