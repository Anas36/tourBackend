package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Preference;
import com.example.tour.services.PreferenceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("preferences")
public class PreferenceController {

    public PreferenceService preferenceService;

    public PreferenceController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    @GetMapping
    List<Preference> getPreferences()  {
        return preferenceService.getAllPreferences();
    }

    @GetMapping("/{id}")
    Preference getPreference(@PathVariable long id)  {
        return preferenceService.getPreferenceById(id);
    }











}
