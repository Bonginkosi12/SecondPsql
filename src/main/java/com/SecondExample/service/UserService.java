package com.SecondExample.service;

import com.SecondExample.dto.UserDto;
import com.SecondExample.entity.User;
import com.SecondExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // Method to get user by name
    public UserDto getUserByName(String name) {
        User user = userRepository.findByName(name);

        if (user == null) {
            return null;
        }

        return new UserDto(
                user.getName(),
                user.getRole(),
                user.getEmail(),
                user.getMobileNumbers()
        );
    }

    // Method to get user by role
    public List<UserDto> getUsersByRole(String role) {
        List<User> users = userRepository.findByRole(role);


        return users.stream()
                .map(user -> new UserDto(
                        user.getName(),
                        user.getRole(),
                        user.getEmail(),
                        user.getMobileNumbers()
                ))
                .toList();
    }


    // Method using request params to find user by email and mobileNumbers
    public UserDto getUserByEmailAndMobileNumber(String email, String mobileNumbers) {
        User user = userRepository.findByEmailAndMobileNumbers(email, mobileNumbers);

        if (user == null) {
            return null;
        }

        return new UserDto(
                user.getName(),
                user.getRole(),
                user.getEmail(),
                user.getMobileNumbers()
        );
    }

}
