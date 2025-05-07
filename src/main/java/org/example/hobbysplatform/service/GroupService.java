package org.example.hobbysplatform.service;

import lombok.RequiredArgsConstructor;
import org.example.hobbysplatform.model.Group;
import org.example.hobbysplatform.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Optional<Group> findById(Long id) {
        return groupRepository.findById(id);
    }

    public Group save(Group group) {
        return groupRepository.save(group);
    }

    public Group update(Long id, Group groupDetails) {
        Group existingGroup = groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + id));

        existingGroup.setTitle(groupDetails.getTitle());
        existingGroup.setDescription(groupDetails.getDescription());
        existingGroup.setMembersCount(groupDetails.getMembersCount());
        existingGroup.setOpenGroup(groupDetails.isOpenGroup());
        existingGroup.setHobbyTag(groupDetails.getHobbyTag());

        return groupRepository.save(existingGroup);
    }

    public void delete(Long id) {
        groupRepository.deleteById(id);
    }

    public List<Group> findByHobbyTag(String hobbyTag) {
        return groupRepository.findByHobbyTag(hobbyTag);
    }

    public List<Group> findByOpenGroup(boolean openGroup) {
        return groupRepository.findByOpenGroup(openGroup);
    }
}