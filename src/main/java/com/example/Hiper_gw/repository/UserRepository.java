package com.example.Hiper_gw.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Hiper_gw.dtos.UserDto;
import com.example.Hiper_gw.models.User;


public interface UserRepository extends JpaRepository<User, Long> {

  @Query("select u.id from User u where u.email = :email and u.password = :password")
  User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

  Optional<User> findByEmail(String email);

}
