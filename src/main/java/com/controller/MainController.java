package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;

import service.UserService;

@RestController
@RequestMapping
public class MainController {
    @Autowired
    UserService userService;

    @PostMapping("/getUser")
    public User getUser(@RequestBody User user)
    {
        return userService.getUser(user);
    }
    @PutMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.insertIntoDatabase(user);
    }
    
}
