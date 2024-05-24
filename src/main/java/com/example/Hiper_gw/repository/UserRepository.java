package com.example.Hiper_gw.repository;

import com.example.Hiper_gw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
