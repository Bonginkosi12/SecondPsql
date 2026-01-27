package com.SecondExample.service;

import com.SecondExample.dto.UserDto;
import com.SecondExample.entity.User;
import com.SecondExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Method to create a new user(resource)
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setRole(userDto.getRole());
        user.setEmail(userDto.getEmail());
        user.setMobileNumbers(userDto.getMobileNumbers());
        userRepository.save(user);

        return userDto;
    }

    // method to get user by name




}
