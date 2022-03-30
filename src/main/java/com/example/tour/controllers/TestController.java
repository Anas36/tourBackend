package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @GetMapping("/welcome")
    public String getWord(){
        return "Welcome name";
    }

}
