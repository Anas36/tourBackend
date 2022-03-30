package com.example.tour.controllers;

import com.example.tour.data.TourRepo;
import com.example.tour.models.Tour;
import com.example.tour.models.TourCreator;
import com.example.tour.services.TourService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("tours")
public class TourController {

    private TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public List<Tour> getTours(){
        return tourService.getAllTours();
    }

    @GetMapping("/{id}")
    public Tour getTourById(@PathVariable long id){
        return tourService.getTourById(id);
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
