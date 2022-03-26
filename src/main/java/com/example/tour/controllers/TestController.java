package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.User;
import com.example.tour.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @GetMapping("/welcome")
    public String getWord(){
        return "Welcome name";
    }

}
