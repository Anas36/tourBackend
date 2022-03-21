package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Quote;
import com.example.tour.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuoteController {

    public QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping(path = "/quotes")
    List<Quote> getQuotes()  {
        return quoteService.getListOfQuotes();
    }


    @PostMapping(path = "quotes")
    void addNewQuoteOrUpdate(@RequestBody(required = true) Quote quote) {
        quoteService.saveQuote(quote);
    }


}
