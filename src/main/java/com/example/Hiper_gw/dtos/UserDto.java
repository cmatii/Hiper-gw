package com.example.Hiper_gw.dtos;

import com.example.Hiper_gw.models.User;


public record UserDto(  Long id, String name, String email) {


    public UserDto(User u){
        this(u.getId(),u.getName(),u.getEmail());
    }

    public User toUserEntity(){
        return new User(id,name,email);
    }

} 

    

