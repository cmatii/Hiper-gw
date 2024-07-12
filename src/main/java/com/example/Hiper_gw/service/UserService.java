package com.example.Hiper_gw.service;

import com.example.Hiper_gw.dtos.LoginUserDto;
import com.example.Hiper_gw.dtos.RegisterUserDto;
import com.example.Hiper_gw.dtos.UserDto;
import com.example.Hiper_gw.mapper.UserMapper;
import com.example.Hiper_gw.models.User;
import com.example.Hiper_gw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    private AuthenticationManager authenticationManager;

    private PasswordEncoder passwordEncoder;

    private UserMapper userMapper;


    @Autowired
    public UserService(final UserRepository userRepository,AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder ) {
        this.userRepository = userRepository;
        this.authenticationManager=authenticationManager;
        this.passwordEncoder=passwordEncoder;
    }


    public UserDto createUser(UserDto userDto){
        return new UserDto(userRepository.save(userDto.toUserEntity()));
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream().map(UserDto::new).toList();
    }


    public UserDto getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userMapper.convertEntityToDto(userOptional.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }

     public User signup(RegisterUserDto input) {
        User user = new User();
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }


    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }


    public User updateUser(Long id, User user){
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
