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

    // fixMe: Instead of using User use UserDto
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    //fixMe: create GET method to get user by name



}
