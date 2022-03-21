package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Quote;
import com.example.tour.services.QuoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    public QuoteService quoteService;

    public UserController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping()
    List<Quote> getQuotes()  {
        return quoteService.getListOfQuotes();
    }





}
