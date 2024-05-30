package com.example.Hiper_gw;

import com.example.Hiper_gw.model.User;
import com.example.Hiper_gw.repository.UserRepository;
import com.example.Hiper_gw.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userservice;

    @Mock
    private UserRepository userrepository;

    @Test
    public void testGetUserById() {
        // Arrange
        long userId = 1L;
        User mockUser = new User(userId, "Petter pan", "petter@example.com");

        // Mock the behavior of the repository to return the mock User
        Mockito.when(userrepository.findById(userId)).thenReturn(Optional.of(mockUser));

        // Act
        User result = userservice.getUserById(userId);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getId());
        assertEquals("Petter pan", result.getName());
        assertEquals("petter@example.com", result.getEmail());
    }


}
