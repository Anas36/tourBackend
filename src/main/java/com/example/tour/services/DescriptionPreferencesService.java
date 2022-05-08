package com.example.tour.services;

//Business Logic layer

import com.example.tour.data.AuthorityRepo;
import com.example.tour.data.DescriptionPreferencesRepo;
import com.example.tour.data.ObjectRepo;
import com.example.tour.models.CompositeKey.DescriptionPreferencesKey;
import com.example.tour.models.CompositeKey.ObjectKey;
import com.example.tour.models.DescriptionPreferences;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionPreferencesService {

    final DescriptionPreferencesRepo descriptionPreferencesRepo;
    final ObjectRepo objectRepo;
    final AuthorityRepo authorityRepo;


    public DescriptionPreferencesService(DescriptionPreferencesRepo descriptionPreferencesRepo, ObjectRepo objectRepo, AuthorityRepo authorityRepo) {
        this.descriptionPreferencesRepo = descriptionPreferencesRepo;
        this.objectRepo = objectRepo;
        this.authorityRepo = authorityRepo;
    }

    public List<DescriptionPreferences> getAllDescriptionPreferences()
    {
        return descriptionPreferencesRepo.findAll();
    }

}
