package com.example.tour.controllers;

import com.example.tour.models.Tour;
import com.example.tour.services.TourRatingService;
import com.example.tour.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tours")
public class TourController {


    private TourService tourService;
    private TourRatingService tourRatingService;

    @Autowired
    public TourController(TourService tourService, TourRatingService tourRatingService) {
        this.tourService = tourService;
        this.tourRatingService = tourRatingService;
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







}
