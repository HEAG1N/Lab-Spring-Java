package org.example.hobbysplatform.service;

import lombok.RequiredArgsConstructor;
import org.example.hobbysplatform.model.User;
import org.example.hobbysplatform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User userDetails) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existingUser.setUsername(userDetails.getUsername());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setAge(userDetails.getAge());
        existingUser.setHobby(userDetails.getHobby());
        existingUser.setActive(userDetails.isActive());
        existingUser.setEvent(userDetails.getEvent());
        existingUser.setGroup(userDetails.getGroup());

        return userRepository.save(existingUser);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findByHobby(String hobby) {
        return userRepository.findByHobby(hobby);
    }

    public List<User> findByEventId(Long eventId) {
        return userRepository.findByEventId(eventId);
    }

    public List<User> findByGroupId(Long groupId) {
        return userRepository.findByGroupId(groupId);
    }
}
