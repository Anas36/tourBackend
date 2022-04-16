package com.example.tour.services;

import com.example.tour.data.PlaceRepo;
import com.example.tour.models.Place;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    final PlaceRepo placeRepo;


    public PlaceService(PlaceRepo placeRepo) {
        this.placeRepo = placeRepo;
    }

    public List<Place> getAllPlaces()
    {
        return placeRepo.findAll();

    }

    public Place getPlaceById(long id) {
        return placeRepo.findById(id).orElse(null);
    }

    public void deletePlaceById(long id) {
        if (!placeRepo.existsById(id)) {
            throw new IllegalStateException("Place Not Exist");
        } else {
            placeRepo.deleteById(id);
        }

    }

    public String savePlace(Place place) {
        placeRepo.save(place);
        return "place been added successfully";
    }
}
