package com.example.tour.services;

import com.example.tour.data.TourRepo;
import com.example.tour.models.Tour;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    final TourRepo tourRepo;

    public TourService(TourRepo tourRepo) {
        this.tourRepo = tourRepo;
    }


    public List<Tour> getAllTours()
    {
        return tourRepo.findAll();

    }

    public Tour getTourById(long id) {
        return tourRepo.findById(id).orElse(null);
    }

    public String deleteTourById(long id) {
        if (!tourRepo.existsById(id)) {
            throw new IllegalStateException("Tour Not Exist");
        } else {
            tourRepo.deleteById(id);
            return "tour" + id + "been deleted";
        }

    }

    public String saveTour(Tour tour) {
        tourRepo.save(tour);
        return "added tour successfully with id : " + tour.getId();
    }


}
