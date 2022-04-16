package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Preference;
import com.example.tour.models.Visitor;
import com.example.tour.services.PreferenceService;
import com.example.tour.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Set;

@RestController
@RequestMapping("visitor/preferences")
public class VisitorPreferencesController {


    private VisitorService visitorService;
    private PreferenceService preferenceService;

    @Autowired
    public VisitorPreferencesController(VisitorService visitorService, PreferenceService preferenceService) {
        this.visitorService = visitorService;
        this.preferenceService = preferenceService;
    }

    @GetMapping("/{id}/good")
    Set<Preference> getVisitorPreferences(@PathVariable long id) throws Exception {
        Visitor visitor;
        if (visitorService.getVisitorById(id) != null){
             visitor = (Visitor) visitorService.getVisitorById(id);
        }
        else
        {
            throw new Exception("there no visitor with this id");
        }
        return visitor.getChosenPreferences();
    }




//    Set<Visitor> getPreferenceFollowers(@PathVariable long id) throws Exception {
//
//    }














}
