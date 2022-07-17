package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.CompositeKey.ObjectKey;
import com.example.tour.models.GeneralDescription;
import com.example.tour.models.Object;
import com.example.tour.services.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("objects")
public class ObjectController {

    private final ObjectService objectService;

    @Autowired
    public ObjectController(ObjectService objectService) {
        this.objectService = objectService;
    }


    @GetMapping("/objects")
    List<Object> getObjects()  {
        return objectService.getAllObjects();
    }

    @GetMapping("/place/{placeId}/room/{roomId}/object/{objectId}")
    Object getObjectById(@PathVariable long placeId,@PathVariable long roomId,@PathVariable long objectId) throws Exception {
        ObjectKey objectKey = new ObjectKey(objectId,placeId,roomId);
        return objectService.getObjectById(objectKey);
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

    @GetMapping("object/descriptions/general/{placeId}/{roomId}/{objectId}")
    List<GeneralDescription> getObjectGeneralDescriptions(@PathVariable long placeId, @PathVariable long roomId, @PathVariable long objectId) {
        ObjectKey objectKey = new ObjectKey(objectId,placeId,roomId);
        return objectService.getObjectGeneralDescription(objectKey);
    }









}
