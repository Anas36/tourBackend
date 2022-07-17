package com.example.tour.services;

//Business Logic layer

import com.example.tour.data.AuthorityRepo;
import com.example.tour.data.DescriptionPreferencesRepo;
import com.example.tour.data.ObjectRepo;
import com.example.tour.models.DescriptionPreferences;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DescriptionPreferencesService {

    private final DescriptionPreferencesRepo descriptionPreferencesRepo;
    private final ObjectRepo objectRepo;
    private final AuthorityRepo authorityRepo;


    public List<DescriptionPreferences> getAllDescriptionPreferences()
    {
        return descriptionPreferencesRepo.findAll();
    }

}
