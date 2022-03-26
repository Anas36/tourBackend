package com.example.tour.services;

import com.example.tour.data.VisitorRepo;
import com.example.tour.models.Preference;
import com.example.tour.models.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitorPreferencesService {
    final VisitorRepo visitorRepo;
    private VisitorService visitorService;


    @Autowired
    public VisitorPreferencesService(VisitorRepo visitorRepo, VisitorService visitorService) {
        this.visitorRepo = visitorRepo;
        this.visitorService = visitorService;
    }



    Set<Preference> getVisitorPreferences(long id) throws Exception {
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
}
