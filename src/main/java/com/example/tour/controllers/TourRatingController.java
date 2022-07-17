package com.example.tour.controllers;

import com.example.tour.models.TourRating;
import com.example.tour.services.TourRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rating")
@RequiredArgsConstructor
public class TourRatingController {


    private final TourRatingService tourRatingService;


    @GetMapping()
    List<TourRating> getRatings() {
            return tourRatingService.getRatings();
    }

//    void updateRecommendedRatings(List<TourRating> ratings) {
//        tourRatingService.updateRecommendedRatings(ratings);
//    }




}
