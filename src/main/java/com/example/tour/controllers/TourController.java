package com.example.tour.controllers;

import com.example.tour.models.Tour;
import com.example.tour.services.TicketService;
import com.example.tour.services.TourRatingService;
import com.example.tour.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("tours")
public class TourController {


    private TourService tourService;
    private TourRatingService tourRatingService;
    private TicketService ticketService;


    @Autowired
    public TourController(TourService tourService, TourRatingService tourRatingService, TicketService ticketService) {
        this.tourService = tourService;
        this.tourRatingService = tourRatingService;
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Tour> getTours(){
        return tourService.getAllTours();
    }

    @GetMapping("/{id}")
    public Tour getTourById(@PathVariable long id){
        return tourService.getTourById(id);
    }

    @GetMapping("/{id}/rating/")
    public List<Object> getAvgTourRating(@PathVariable long id){
        return tourRatingService.getTourRatings(id);
    }

    @DeleteMapping("{id}")
    public String deleteTourById(@PathVariable long id){
        return tourService.deleteTourById(id);
    }

    @PostMapping
    public String addTour(@RequestBody Tour tour){
        return tourService.saveTour(tour);
    }

    @GetMapping("/count")
    int getCountTicketByDateAndTour(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam Tour tour)  {
        return ticketService.getCountOfBookedTickets(tour,date);
    }



}
