package com.devbuse.OrganizationManagement.service;

import com.devbuse.OrganizationManagement.data.entity.EventEntity;
import com.devbuse.OrganizationManagement.data.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private IEventRepository eventRepository;


    public EventEntity createEvent(EventEntity event) {
        return eventRepository.save(event);
    }

    public List<EventEntity> getAllEvents() {
        return eventRepository.findAll();
    }

    public EventEntity getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }

    public EventEntity updateEvent(Long id, EventEntity event) {
        EventEntity existingEvent = getEventById(id);
        existingEvent.setEventDescription(event.getEventDescription());
        existingEvent.setEventLocation(event.getEventLocation());
        existingEvent.setStartDate(event.getStartDate());
        existingEvent.setEndDate(event.getEndDate());
        existingEvent.setParticipantEntities(event.getParticipantEntities());
        return eventRepository.save(existingEvent);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
