package com.example.tour.services;

import com.example.tour.data.TourRatingRepo;
import com.example.tour.data.selectInterface.AvgTourRating;
import com.example.tour.models.TourRating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourRatingService {

    private final TourRatingRepo tourRatingRepo;


    public List<Object> getTourRatings(long id){
        return tourRatingRepo.findByTourId(id);
    }

    public Double getTourCreatorRating(long id) {
        return tourRatingRepo.getTourCreatorRating(id);
    }


    public String saveTourRating(TourRating tourRating) {
        tourRatingRepo.save(tourRating);
        return "rating been saved successfully";
    }

    public List<AvgTourRating> getTopTours() {
        return tourRatingRepo.findTopTour();
    }

    public List<TourRating> getRatings() {
        return tourRatingRepo.findAll();
    }

    public List<Object> getVisitorRatings(long id){
        return tourRatingRepo.findByVisitorId(id);
    }

//    public void updateRecommendedRatings(List<TourRating> ratings) {
//        tourRatingRepo.updateRecommendedRatings(ratings);
//    }
}
