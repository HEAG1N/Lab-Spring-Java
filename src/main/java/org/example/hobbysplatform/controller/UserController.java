package org.example.hobbysplatform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.hobbysplatform.model.User;
import org.example.hobbysplatform.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j  // Add logging capability
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            log.info("Fetching all users");
            List<User> users = userService.findAll();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            log.error("Error fetching all users", e);
            throw e;  // Let the global exception handler handle it
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        try {
            log.info("Fetching user with id: {}", id);
            return userService.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            log.error("Error fetching user with id: {}", id, e);
            throw e;
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        try {
            log.info("Creating new user: {}", user.getUsername());
            User savedUser = userService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (Exception e) {
            log.error("Error creating user: {}", user.getUsername(), e);
            throw e;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        try {
            log.info("Updating user with id: {}", id);
            User updatedUser = userService.update(id, user);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            log.error("Error updating user with id: {}", id, e);
            throw e;
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> partialUpdateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            log.info("Partially updating user with id: {}", id);
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
            if (user.isActive() != currentUser.isActive()) {
                currentUser.setActive(user.isActive());
            }

            return ResponseEntity.ok(userService.save(currentUser));
        } catch (Exception e) {
            log.error("Error partially updating user with id: {}", id, e);
            throw e;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            log.info("Deleting user with id: {}", id);
            userService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Error deleting user with id: {}", id, e);
            throw e;
        }
    }

}