package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.CompositeKey.TourRatingKey;
import com.example.tour.models.Preference;
import com.example.tour.models.TourRating;
import com.example.tour.models.User;
import com.example.tour.models.Visitor;
import com.example.tour.services.PreferenceService;
import com.example.tour.services.TourRatingService;
import com.example.tour.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("visitors")
public class VisitorController {

    public VisitorService visitorService;
    private PreferenceService preferenceService;
    private TourRatingService tourRatingService;

    @Autowired
    public VisitorController(VisitorService visitorService, PreferenceService preferenceService, TourRatingService tourRatingService) {
        this.visitorService = visitorService;
        this.preferenceService = preferenceService;
        this.tourRatingService = tourRatingService;
    }



    @GetMapping
    List<Visitor> getVisitors() {
        return visitorService.getAllVisitors();
    }

    @GetMapping("/{id}")
    Visitor getVisitor(@PathVariable long id) {
        return visitorService.getVisitorById(id);
    }

    @PostMapping("/rating/")
    String addTourRating(@RequestBody TourRating tourRating) {
        return  tourRatingService.saveTourRating(tourRating);
    }

    @DeleteMapping("/{id}")
    void removeVisitor(@PathVariable long id) {
        visitorService.deleteVisitorById(id);
    }


    @GetMapping("/{id}/preferences")
    Set<Preference> getVisitorPreferences(@PathVariable long id) throws Exception {
        Visitor visitor;
        if (visitorService.getVisitorById(id) != null) {
            visitor = (Visitor) visitorService.getVisitorById(id);
        } else {
            throw new Exception("there no visitor with this id");
        }
        return visitor.getChosenPreferences();
    }

    @PostMapping("/{id}/preferences")
    String setVisitorPreferences(@PathVariable long id, @RequestBody Set<Preference> preferences) throws Exception {
        Visitor visitor;

        if (visitorService.getVisitorById(id) != null) {
            visitor = (Visitor) visitorService.getVisitorById(id);
            System.out.println(visitor);
        }
        else {
            throw new Exception("there no visitor with this id");
        }
        System.out.println(preferences);

        visitor.setChosenPreferences(preferences);

        for (Preference preference : preferences) {
            Preference tmpPreference = preferenceService.getPreferenceById(preference.getId());
            tmpPreference.addVisitor(visitor);
            preferenceService.savePrefernce(tmpPreference);
        }

        visitorService.saveVisitor(visitor);
        return visitor.getChosenPreferences().toString();
    }






}
