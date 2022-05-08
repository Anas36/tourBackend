package com.example.tour.services;

//Business Logic layer


import com.example.tour.data.DescriptionPreferencesRepo;
import com.example.tour.data.ExtraDescriptionRepo;
import com.example.tour.data.ObjectRepo;
import com.example.tour.data.TourCreatorRepo;
import com.example.tour.models.CompositeKey.ExtraDescriptionKey;
import com.example.tour.models.CompositeKey.ObjectKey;
import com.example.tour.models.DescriptionPreferences;
import com.example.tour.models.ExtraDescription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraDescriptionService {

    final ExtraDescriptionRepo extraDescriptionRepo;
    final ObjectRepo objectRepo;
    final TourCreatorRepo tourCreatorRepo;
    final DescriptionPreferencesRepo descriptionPreferencesRepo;


    public ExtraDescriptionService(ExtraDescriptionRepo extraDescriptionRepo, ObjectRepo objectRepo, TourCreatorRepo tourCreatorRepo, DescriptionPreferencesRepo descriptionPreferencesRepo) {
        this.extraDescriptionRepo = extraDescriptionRepo;
        this.objectRepo = objectRepo;
        this.tourCreatorRepo = tourCreatorRepo;
        this.descriptionPreferencesRepo = descriptionPreferencesRepo;
    }

    public List<ExtraDescription> getAllDescriptions()
    {
        return extraDescriptionRepo.findAll();
    }

    public String saveDescription(ExtraDescription extraDescription) throws Exception {
        if (!objectRepo.existsById(new ObjectKey(extraDescription.getObjectId(),extraDescription.getPlaceId(),extraDescription.getRoomId())))
            throw new Exception("there is no object with this id");
        if (!tourCreatorRepo.existsById(extraDescription.getTourCreatorId()))
            throw new Exception("there is no Tour Creator with this details");
        extraDescriptionRepo.save(extraDescription);
        return "description with id " + extraDescription.getId() + " been added";
    }


    public ExtraDescription getExtraDescriptionById(ExtraDescriptionKey id) throws Exception {
        if (!objectRepo.existsById(new ObjectKey(id.getObjectId(),id.getPlaceId(),id.getRoomId())))
            throw new Exception("there is no object with this id");
        if (!tourCreatorRepo.existsById(id.getTourCreatorId()))
            throw new Exception("there is no Tour Creator id with this details");

        return extraDescriptionRepo.findById(id).orElse(null);
    }

    public String saveDescriptionPreferences(DescriptionPreferences descriptionPreferences) {
        descriptionPreferencesRepo.save(descriptionPreferences);
        return "Preferences been added";
    }
}
