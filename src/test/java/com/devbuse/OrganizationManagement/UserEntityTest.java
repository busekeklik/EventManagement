package com.devbuse.OrganizationManagement;

import static org.junit.jupiter.api.Assertions.*;
import com.devbuse.OrganizationManagement.data.entity.EventEntity;
import com.devbuse.OrganizationManagement.data.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserEntityTest {
    private UserEntity userEntity;

    @BeforeEach
    void setUp(){
        userEntity = new UserEntity();
        userEntity.setUserName("Anna");
        userEntity.setEmail("anna@gmail.com");
        userEntity.setPassword("sfdsfd");
        userEntity.setEventEntities(List.of(new EventEntity()));
    }

    @Test
    @DisplayName("Name is set correctly")
    void testName(){
        assertEquals("Anna", userEntity.getUserName());
    }

    @Test
    @DisplayName("Email is set correctly")
    void testEmail(){
        assertEquals("anna@gmail.com", userEntity.getEmail());
    }

    @Test
    @DisplayName("Password is set correctly")
    void testPassword(){
        assertNotNull(userEntity.getPassword());
    }

    @Test
    @DisplayName("Event entities are set correctly")
    void testUserEntities() {
        assertFalse(userEntity.getEventEntities().isEmpty());
    }
}
