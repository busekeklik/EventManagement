package com.devbuse.OrganizationManagement.service;

import com.devbuse.OrganizationManagement.data.entity.ParticipantEntity;
import com.devbuse.OrganizationManagement.data.repository.IParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    @Autowired
    private IParticipantRepository participantRepository;

    public ParticipantEntity createParticipant(ParticipantEntity participant) {
        return participantRepository.save(participant);
    }

    public List<ParticipantEntity> getAllParticipants() {
        return participantRepository.findAll();
    }

    public ParticipantEntity getParticipantById(Long id) {
        return participantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Participant not found with id: " + id));
    }

    public ParticipantEntity updateParticipant(Long id, ParticipantEntity participant) {
        ParticipantEntity existingParticipant = getParticipantById(id);
        existingParticipant.setEvents(participant.getEvents());
        return participantRepository.save(existingParticipant);
    }

    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }
}
