package com.devbuse.OrganizationManagement;

import static org.junit.jupiter.api.Assertions.*;

import com.devbuse.OrganizationManagement.data.entity.EventEntity;
import com.devbuse.OrganizationManagement.data.entity.ParticipantEntity;
import com.devbuse.OrganizationManagement.data.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;

public class EventEntityTest {

    private EventEntity event;

    @BeforeEach
    void setUp() {
        event = new EventEntity();
        event.setEventDescription("Annual Tech Conference");
        event.setEventLocation("Istanbul, Turkey");
        event.setStartDate(new Date());
        event.setEndDate(new Date());
        event.setUserEntities(List.of(new UserEntity()));
        event.setParticipantEntities(List.of(new ParticipantEntity()));
    }

    @Test
    @DisplayName("Event description is set correctly")
    void testEventDescription() {
        assertEquals("Annual Tech Conference", event.getEventDescription());
    }

    @Test
    @DisplayName("Event location is set correctly")
    void testEventLocation() {
        assertEquals("Istanbul, Turkey", event.getEventLocation());
    }

    @Test
    @DisplayName("Event start date is set correctly")
    void testStartDate() {
        assertNotNull(event.getStartDate());
    }

    @Test
    @DisplayName("Event end date is set correctly")
    void testEndDate() {
        assertNotNull(event.getEndDate());
    }

    @Test
    @DisplayName("User entities are set correctly")
    void testUserEntities() {
        assertFalse(event.getUserEntities().isEmpty());
    }

    @Test
    @DisplayName("Participant entities are set correctly")
    void testParticipantEntities() {
        assertFalse(event.getParticipantEntities().isEmpty());
    }
}
