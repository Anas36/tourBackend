package com.example.tour.services;

import com.example.tour.data.TourCreatorRepo;
import com.example.tour.data.TourRatingRepo;
import com.example.tour.data.selectInterface.AvgTourCreatorRating;
import com.example.tour.data.selectInterface.TourCreatorProfile;
import com.example.tour.models.User;
import com.example.tour.models.TourCreator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourCreatorService {
    final TourCreatorRepo tourCreatorRepo;
    final TourRatingRepo tourRatingRepo;


    public TourCreatorService(TourCreatorRepo tourCreatorRepo, TourRatingRepo tourRatingRepo) {
        this.tourCreatorRepo = tourCreatorRepo;
        this.tourRatingRepo = tourRatingRepo;
    }

    public List<TourCreator> getAllTourCreators()
    {
        List<User> tmp = tourCreatorRepo.findAll();
        List<TourCreator> result = new ArrayList<>();
        for (User user : tmp) {
            if(user instanceof  TourCreator)
            {
                result.add((TourCreator) user);
            }

        }
        return result;
    }

    public User getTourCreatorById(long id) {
        return tourCreatorRepo.findById(id).orElse(null);
    }

    public void deleteTourCreatorById(long id) {
        if (!tourCreatorRepo.existsById(id)) {
            throw new IllegalStateException("TourCreator Not Exist");
        } else {

            tourCreatorRepo.deleteById(id);
        }

    }

    public void saveTourCreator(TourCreator tourCreator) {
        tourCreatorRepo.save(tourCreator);
    }


    public TourCreatorProfile getTourCreatorProfile(long id) {
        return tourCreatorRepo.findTourCreatorProfile(id);
    }

    public List<AvgTourCreatorRating> getTopTourCreators() {
        return tourRatingRepo.findTopTourCreator();
    }

}
