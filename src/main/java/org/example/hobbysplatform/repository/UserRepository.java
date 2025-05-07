package org.example.hobbysplatform.repository;

import org.example.hobbysplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findByHobby(String hobby);
    List<User> findByActive(boolean active);
    List<User> findByAgeGreaterThan(int age);
    List<User> findByEventId(Long eventId);
    List<User> findByGroupId(Long groupId);
}