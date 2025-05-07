package org.example.hobbysplatform.controller;

import lombok.RequiredArgsConstructor;
import org.example.hobbysplatform.model.User;
import org.example.hobbysplatform.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.update(id, user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> partialUpdateUser(@PathVariable Long id, @RequestBody User user) {
        User currentUser = userService.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Only update non-null fields
        if (user.getUsername() != null) {
            currentUser.setUsername(user.getUsername());
        }
        if (user.getEmail() != null) {
            currentUser.setEmail(user.getEmail());
        }
        if (user.getAge() > 0) {
            currentUser.setAge(user.getAge());
        }
        if (user.getHobby() != null) {
            currentUser.setHobby(user.getHobby());
        }

        return ResponseEntity.ok(userService.save(currentUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/hobby/{hobby}")
    public ResponseEntity<List<User>> getUsersByHobby(@PathVariable String hobby) {
        return ResponseEntity.ok(userService.findByHobby(hobby));
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<User>> getUsersByEventId(@PathVariable Long eventId) {
        return ResponseEntity.ok(userService.findByEventId(eventId));
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<User>> getUsersByGroupId(@PathVariable Long groupId) {
        return ResponseEntity.ok(userService.findByGroupId(groupId));
    }
}