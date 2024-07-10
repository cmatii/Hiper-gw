package com.example.Hiper_gw.dtos;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Hiper_gw.models.User;

@CrossOrigin

public record UserDto(  Long id, String name, String email, String password) {


    public UserDto(User u){
        this(u.getId(),u.getName(),u.getEmail(), u.getPassword());
        System.out.println("************* U value: *************");
        System.out.println(u.toString());
    }

    public User toUserEntity(){
        return new User(id,name,email,password);
    }

} 

    

