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

    @GetMapping("/{id}")
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

    @PostMapping("/{id}")
    String addVisitorPreferences(@PathVariable long id,@RequestBody Set<Preference> preferences) throws Exception {
        Visitor visitor;
        if (visitorService.getVisitorById(id) != null){
            visitor = (Visitor) visitorService.getVisitorById(id);
            System.out.println(visitor);
        }
        else
        {
            throw new Exception("there no visitor with this id");
        }
        System.out.println(preferences);
        visitor.setChosenPreferences(preferences);
        for(Preference preference: preferences)
        {
            Preference tmpPreference = preferenceService.getPreferenceById(preference.getId());
            tmpPreference.addVisitor(visitor);
            preferenceService.savePrefernce(tmpPreference);
        }

        visitorService.saveVisitor(visitor);
        return visitor.getChosenPreferences().toString();
    }


//    Set<Visitor> getPreferenceFollowers(@PathVariable long id) throws Exception {
//
//    }














}
