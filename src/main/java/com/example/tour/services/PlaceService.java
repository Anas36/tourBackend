package com.example.tour.services;

import com.example.tour.data.PlaceRepo;
import com.example.tour.models.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepo placeRepo;


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

    public String placeAcceptance(long id,boolean acceptance) {
        Place place = placeRepo.getById(id);
        place.setAccepted(acceptance);
        placeRepo.save(place);
        return "place acceptance been changed";
    }
    public String savePlace(Place place) {
        placeRepo.save(place);
        return "place been added successfully";
    }
}
