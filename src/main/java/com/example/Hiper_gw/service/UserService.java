package com.example.Hiper_gw.service;

import com.example.Hiper_gw.dtos.UserDto;
import com.example.Hiper_gw.models.User;
import com.example.Hiper_gw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    
    private UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDto createUser(UserDto userDto){
        return new UserDto(userRepository.save(userDto.toUserEntity()));
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream().map(UserDto::new).toList();
    }

    public UserDto getUserById(Long id){
        return new UserDto(userRepository.findById(id).orElse(null));
    }

    public User updateUser(Long id, User user){
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
