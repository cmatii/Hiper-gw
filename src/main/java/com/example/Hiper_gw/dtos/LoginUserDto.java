package com.example.Hiper_gw.dtos;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Hiper_gw.models.User;


public record LoginUserDto( String email, String password) {

    public LoginUserDto(User u) {
        this(u.getEmail(), u.getPassword());
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    

}
