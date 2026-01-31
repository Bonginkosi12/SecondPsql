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

    //A patch method to update user's email and mobileNumbers
    public UserDto updateEmailAndMobile(Integer id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }

        if (userDto.getMobileNumbers() != null) {
            user.setMobileNumbers(userDto.getMobileNumbers());
        }

          userRepository.save(user);

        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getMobileNumbers()
        );
    }

    // Method to delete user
    public void deleteUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }

    //A GET method list to return all users order by  name
    public List<UserDto> getAllUsersOrderedByName() {

        List<User> users = userRepository.findAllByOrderByNameAsc();

        return users.stream()
                .map(user -> new UserDto(
                        user.getId(),
                        user.getName(),
                        user.getRole(),
                        user.getEmail(),
                        user.getMobileNumbers()
                ))
                .toList();
    }

}
