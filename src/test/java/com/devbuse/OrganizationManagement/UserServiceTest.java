package com.devbuse.OrganizationManagement;

import com.devbuse.OrganizationManagement.data.entity.EventEntity;
import com.devbuse.OrganizationManagement.data.entity.UserEntity;
import com.devbuse.OrganizationManagement.data.repository.IUserRepository;
import com.devbuse.OrganizationManagement.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

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
    @DisplayName("User Created")
    void testCreateUser(){
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);
        UserEntity created = userService.createUser(userEntity);
        assertSame(userEntity, created);
    }

    @Test
    @DisplayName("Get all users")
    void testGetAllUsers(){
        when(userRepository.findAll()).thenReturn(Arrays.asList(userEntity));
        List<UserEntity> users = userService.getAllUsers();
        Assertions.assertFalse(users.isEmpty());
    }

    @Test
    @DisplayName("User found with id")
    void testGetUserById() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(userEntity));
        UserEntity found = userService.getUserById(1L);
        assertNotNull(found);
    }

    @Test
    @DisplayName("User not found with id")
    void testUserNotFound(){
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class, () -> userService.getUserById(1L));
        assertTrue(exception.getMessage().contains("User not found with id: 1"));
    }

    @Test
    @DisplayName("Update user successfully")
    void testUpdateUser() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(userEntity));
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);
        UserEntity updated = userService.updateUser(1L, userEntity);
        assertNotNull(updated);
    }
    @Test
    @DisplayName("Delete event")
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(anyLong());
        assertDoesNotThrow(() -> userService.deleteUser(1L));
    }
}
