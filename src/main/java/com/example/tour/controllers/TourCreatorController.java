package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.data.selectInterface.AvgTourCreatorRating;
import com.example.tour.data.selectInterface.TourCreatorProfile;
import com.example.tour.models.Tour;
import com.example.tour.models.TourCreator;
import com.example.tour.services.TourCreatorService;
import com.example.tour.services.TourRatingService;
import com.example.tour.services.TourService;
import com.example.tour.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("tourCreators")
@RequiredArgsConstructor
public class TourCreatorController {

    private final TourCreatorService tourCreatorService;
    private final TourRatingService tourRatingService;
    private final TourService tourService;
    private final UserService userService;



    @PostMapping()
    TourCreator addTourCreator(@RequestBody TourCreator tourCreator)  {
        tourCreator.setRole();
        return (TourCreator) userService.saveUser(tourCreator);
    }
    @GetMapping
    List<TourCreator> getTourCreators()  {
        return tourCreatorService.getAllTourCreators();
    }
    @GetMapping("/{id}")
    TourCreator getTourCreator(@PathVariable long id) {

            return (TourCreator)tourCreatorService.getTourCreatorById(id);
    }

    @GetMapping("{id}/tours")
    List<Tour> getTours(@PathVariable long id) {
        return tourService.getToursByTourCreatorId(id);
    }

    @GetMapping("{id}/profile")
    TourCreatorProfile getTourCreatorProfile(@PathVariable long id) {
        System.out.println("the id is : "+id);
        return tourCreatorService.getTourCreatorProfile(id);
    }

    @GetMapping("/top")
    Stream<AvgTourCreatorRating> getTopTourCreator() {
        return tourCreatorService.getTopTourCreators().stream().limit(5);
    }



    @GetMapping("/{id}/rating/")
    Double getTourCreatorRating(@PathVariable long id){
        Double rating = tourRatingService.getTourCreatorRating(id);
        if (rating == null)
            rating = 0.0;
        return rating;
    }
    @DeleteMapping("/{id}")
    void removeTourCreator(@PathVariable long id)  {
        tourCreatorService.deleteTourCreatorById(id);
    }



}



