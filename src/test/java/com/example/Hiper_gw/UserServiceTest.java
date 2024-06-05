package com.example.Hiper_gw;

import com.example.Hiper_gw.dtos.UserDto;
import com.example.Hiper_gw.models.User;
import com.example.Hiper_gw.repository.UserRepository;
import com.example.Hiper_gw.service.UserService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testGetUserById( ) {
        // GIVEN
        long userId = 1L;
        User mockUser = new User(userId, "Petter pan", "petter@example.com");

            
        // Mock the behavior of the repository to return the mock User
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.ofNullable(mockUser));

        UserDto savedUser = userService.getUserById(userId);

        //WHEN
        
        // Assert
        Assertions.assertThat(savedUser).isNotNull();

        //assertNotNull(result);
        //assertEquals(userId, result.getId());
        //assertEquals("Petter pan", result.getName());
        //assertEquals("petter@example.com", result.getEmail());
    }


}
