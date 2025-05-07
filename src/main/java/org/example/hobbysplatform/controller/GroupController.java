package org.example.hobbysplatform.controller;

import lombok.RequiredArgsConstructor;
import org.example.hobbysplatform.model.Group;
import org.example.hobbysplatform.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public ResponseEntity<List<Group>> getAllGroups() {
        return ResponseEntity.ok(groupService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id) {
        return groupService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        return ResponseEntity.status(HttpStatus.CREATED).body(groupService.save(group));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable Long id, @RequestBody Group group) {
        return ResponseEntity.ok(groupService.update(id, group));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Group> partialUpdateGroup(@PathVariable Long id, @RequestBody Group group) {
        Group currentGroup = groupService.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + id));

        // Only update non-null fields
        if (group.getTitle() != null) {
            currentGroup.setTitle(group.getTitle());
        }
        if (group.getDescription() != null) {
            currentGroup.setDescription(group.getDescription());
        }
        if (group.getMembersCount() > 0) {
            currentGroup.setMembersCount(group.getMembersCount());
        }
        if (group.getHobbyTag() != null) {
            currentGroup.setHobbyTag(group.getHobbyTag());
        }

        return ResponseEntity.ok(groupService.save(currentGroup));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hobby-tag/{hobbyTag}")
    public ResponseEntity<List<Group>> getGroupsByHobbyTag(@PathVariable String hobbyTag) {
        return ResponseEntity.ok(groupService.findByHobbyTag(hobbyTag));
    }

    @GetMapping("/open/{openGroup}")
    public ResponseEntity<List<Group>> getGroupsByOpenStatus(@PathVariable boolean openGroup) {
        return ResponseEntity.ok(groupService.findByOpenGroup(openGroup));
    }
}