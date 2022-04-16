package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.TourCreator;
import com.example.tour.services.TourCreatorService;
import com.example.tour.services.TourRatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tourCreators")
public class TourCreatorController {

    public TourCreatorService tourCreatorService;
    public TourRatingService tourRatingService;


    public TourCreatorController(TourCreatorService tourCreatorService, TourRatingService tourRatingService) {
        this.tourCreatorService = tourCreatorService;
        this.tourRatingService = tourRatingService;
    }

    @PostMapping()
    void addTourCreator(@RequestBody TourCreator tourCreator)  {
        tourCreatorService.saveTourCreator(tourCreator);
    }
    @GetMapping
    List<TourCreator> getTourCreators()  {
        return tourCreatorService.getAllTourCreators();
    }
    @GetMapping("/{id}")
    TourCreator getTourCreator(@PathVariable long id) throws Exception {
        try
        {
            return (TourCreator)tourCreatorService.getTourCreatorById(id);
        }
        catch(Exception e){
            throw new Exception("there is no TourCreator with this ID");
        }

    }
    @GetMapping("/{id}/rating/")
    Float getTourCreatorRating(@PathVariable long id){
        return tourRatingService.getTourCreatorRating(id);
    }
    @DeleteMapping("/{id}")
    void removeTourCreator(@PathVariable long id)  {
        tourCreatorService.deleteTourCreatorById(id);
    }



}



