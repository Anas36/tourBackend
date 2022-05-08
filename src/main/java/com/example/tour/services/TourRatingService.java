package com.example.tour.services;

import com.example.tour.data.TourRatingRepo;
import com.example.tour.data.selectInterface.AvgTourRating;
import com.example.tour.models.TourRating;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourRatingService {
    final TourRatingRepo tourRatingRepo;


    public TourRatingService(TourRatingRepo tourRatingRepo) {
        this.tourRatingRepo = tourRatingRepo;
    }

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
}
