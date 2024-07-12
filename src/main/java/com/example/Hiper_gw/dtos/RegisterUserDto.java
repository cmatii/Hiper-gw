package com.example.Hiper_gw.dtos;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Hiper_gw.models.User;

@CrossOrigin

public record RegisterUserDto(String email, String password, String name) {

    public RegisterUserDto(User u) {
        this(u.getEmail(), u.getPassword(), u.getName());
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    

}
