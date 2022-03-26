package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.User;
import com.example.tour.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<User> getUsers()  {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    User getUser(@PathVariable long id)  {
        return userService.getUserById(id);
    }








}
