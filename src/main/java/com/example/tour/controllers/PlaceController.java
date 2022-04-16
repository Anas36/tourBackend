package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Place;
import com.example.tour.models.Tour;
import com.example.tour.services.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("places")
public class PlaceController {

    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }


    @GetMapping
    List<Place> getPlaces()  {
        return placeService.getAllPlaces();
    }
    @GetMapping("/{id}")
    Place getPlace(@PathVariable long id)  {
        return placeService.getPlaceById(id);
    }

    @PostMapping
    public String addPlace(@RequestBody Place place){
        return placeService.savePlace(place);
    }









}
