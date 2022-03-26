package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.User;
import com.example.tour.models.TourCreator;
import com.example.tour.services.TourCreatorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tourCreators")
public class TourCreatorController {

    public TourCreatorService tourCreatorService;

    public TourCreatorController(TourCreatorService tourCreatorService) {
        this.tourCreatorService = tourCreatorService;
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
    @DeleteMapping("/{id}")
    void removeTourCreator(@PathVariable long id)  {
        tourCreatorService.deleteTourCreatorById(id);
    }



}
