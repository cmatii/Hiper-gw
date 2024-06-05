package com.example.Hiper_gw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hiper_gw.dtos.UserDto;
import com.example.Hiper_gw.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
