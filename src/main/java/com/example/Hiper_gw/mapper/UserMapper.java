package com.example.Hiper_gw.mapper;

import com.example.Hiper_gw.dtos.UserDto;
import com.example.Hiper_gw.models.User;

public class UserMapper {
    public static UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto(user.getId(),user.getName(),user.getEmail());
        
        return userDto;
    }
}