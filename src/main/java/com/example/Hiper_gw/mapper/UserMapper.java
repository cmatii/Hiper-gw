package com.example.Hiper_gw.mapper;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Hiper_gw.dtos.UserDto;
import com.example.Hiper_gw.models.User;
@CrossOrigin

public class UserMapper {
    public static UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto(user.getId(),user.getName(),user.getEmail(),user.getPassword());
        
        return userDto;
    }
}