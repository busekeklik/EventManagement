package com.devbuse.OrganizationManagement.controller;

import com.devbuse.OrganizationManagement.data.entity.ParticipantEntity;
import com.devbuse.OrganizationManagement.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @PostMapping
    public ParticipantEntity createParticipant(@RequestBody ParticipantEntity participant) {
        return participantService.createParticipant(participant);
    }

    @GetMapping
    public List<ParticipantEntity> getAllParticipants() {
        return participantService.getAllParticipants();
    }

    @GetMapping("/{id}")
    public ParticipantEntity getParticipantById(@PathVariable Long id) {
        return participantService.getParticipantById(id);
    }

    @PutMapping("/{id}")
    public ParticipantEntity updateParticipant(@PathVariable Long id, @RequestBody ParticipantEntity participant) {
        return participantService.updateParticipant(id, participant);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
    }
}
