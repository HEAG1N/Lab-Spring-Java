package org.example.hobbysplatform.repository;

import org.example.hobbysplatform.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findByHobbyTag(String hobbyTag);
    List<Group> findByOpenGroup(boolean openGroup);
    List<Group> findByMembersCountGreaterThan(int membersCount);
    List<Group> findByTitleContainingIgnoreCase(String title);
}