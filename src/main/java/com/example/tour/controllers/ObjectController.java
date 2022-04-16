package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Object;
import com.example.tour.services.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("objects")
public class ObjectController {

    private ObjectService objectService;

    @Autowired
    public ObjectController(ObjectService objectService) {
        this.objectService = objectService;
    }


    @GetMapping("/objects")
    List<Object> getObjects()  {
        return objectService.getAllObjects();
    }

//    @GetMapping("place/{placeID}/room/{roomID}/objects")
//    List<Object>  getObject(@PathVariable long placeID,@PathVariable long roomID)  {
//        return objectService.getObjectsByPlaceId(placeID,roomID);
//    }

    @PostMapping("/object")
    public String addObject(@RequestBody Object object) throws Exception {
        System.out.println(object.toString());
        return objectService.saveObject(object);
    }









}
