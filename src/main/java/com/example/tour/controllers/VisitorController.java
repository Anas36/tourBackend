package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.User;
import com.example.tour.models.Visitor;
import com.example.tour.services.VisitorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("visitors")
public class VisitorController {

    public VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @PostMapping()
    void addVisitor(@RequestBody Visitor visitor) {visitorService.saveVisitor(visitor);}
    @GetMapping
    List<Visitor> getVisitors()  {
        return visitorService.getAllVisitors();
    }
    @GetMapping("/{id}")
    Visitor getVisitor(@PathVariable long id)  {
        return visitorService.getVisitorById(id);
    }
    @DeleteMapping("/{id}")
    void removeVisitor(@PathVariable long id)  {
        visitorService.deleteVisitorById(id);
    }




}
