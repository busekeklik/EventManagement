package com.devbuse.OrganizationManagement;

import com.devbuse.OrganizationManagement.data.entity.EventEntity;
import com.devbuse.OrganizationManagement.data.entity.ParticipantEntity;
import com.devbuse.OrganizationManagement.data.entity.UserEntity;
import com.devbuse.OrganizationManagement.data.repository.IEventRepository;
import com.devbuse.OrganizationManagement.service.EventService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertSame;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {

    @Mock
    private IEventRepository eventRepository;
    @InjectMocks
    private EventService eventService;
    private EventEntity event;

    @BeforeEach
    void setUp(){
        event = new EventEntity();
        event.setEventDescription("Annual Tech Conference");
        event.setEventLocation("Istanbul, Turkey");
        event.setStartDate(new Date());
        event.setEndDate(new Date());
        event.setUserEntities(List.of(new UserEntity()));
        event.setParticipantEntities(List.of(new ParticipantEntity()));
    }

    @Test
    @DisplayName("Event Created")
    void testCreateEvent(){
        when(eventRepository.save(any(EventEntity.class))).thenReturn(event);
        EventEntity created = eventService.createEvent(event);
        assertSame(event, created);
    }

    @Test
    @DisplayName("Get all events")
    void testGetAllEvents(){
        when(eventRepository.findAll()).thenReturn(Arrays.asList(event));
        List<EventEntity> events = eventService.getAllEvents();
        Assertions.assertFalse(events.isEmpty());
    }

    @Test
    @DisplayName("Event found with id")
    void testGetEventById() {
        when(eventRepository.findById(anyLong())).thenReturn(Optional.of(event));
        EventEntity found = eventService.getEventById(1L);
        assertNotNull(found);
    }

    @Test
    @DisplayName("Event not found with id")
    void testEventNotFound() {
        when(eventRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class, () -> eventService.getEventById(1L));
        assertTrue(exception.getMessage().contains("Event not found with id: 1"));
    }

    @Test
    @DisplayName("Update event successfully")
    void testUpdateEvent() {
        when(eventRepository.findById(anyLong())).thenReturn(Optional.of(event));
        when(eventRepository.save(any(EventEntity.class))).thenReturn(event);
        EventEntity updated = eventService.updateEvent(1L, event);
        assertNotNull(updated);
    }

    @Test
    @DisplayName("Delete event")
    void testDeleteEvent() {
        doNothing().when(eventRepository).deleteById(anyLong());
        assertDoesNotThrow(() -> eventService.deleteEvent(1L));
    }
}
