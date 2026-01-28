package com.SecondExample.controller;

import com.SecondExample.dto.UserDto;
import com.SecondExample.entity.User;
import com.SecondExample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // POST method to create new users
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    //GET method to get user by name
    @GetMapping("/name/{name}")
    public UserDto getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    //GET method to get user by role
    @GetMapping("/role/{role}")
    public List<UserDto> getUsersByRole(@PathVariable String role) {
        return userService.getUsersByRole(role);
    }


    // Use request params(find by email and mobile num)

}
