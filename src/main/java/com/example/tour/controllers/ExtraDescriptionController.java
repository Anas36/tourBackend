package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.CompositeKey.ExtraDescriptionKey;
import com.example.tour.models.CompositeKey.GeneralDescriptionKey;
import com.example.tour.models.DescriptionPreferences;
import com.example.tour.models.ExtraDescription;
import com.example.tour.models.GeneralDescription;
import com.example.tour.services.ExtraDescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("descriptions/extra")
public class ExtraDescriptionController {

    public ExtraDescriptionService extraDescriptionService;

    public ExtraDescriptionController(ExtraDescriptionService extraDescriptionService) {
        this.extraDescriptionService = extraDescriptionService;
    }

    @GetMapping
    List<ExtraDescription> getExtraDescriptions()  {
        return extraDescriptionService.getAllDescriptions();
    }

    @PostMapping
    String addExtraDescription(@RequestBody ExtraDescription description) throws Exception {
        System.out.println(description.toString());
        return extraDescriptionService.saveDescription(description);
    }

    @PostMapping("/preferences")
    String addDescriptionPreferences(@RequestBody DescriptionPreferences descriptionPreferences) {
        System.out.println(descriptionPreferences.toString());
        return extraDescriptionService.saveDescriptionPreferences(descriptionPreferences);
    }





    @GetMapping("/{placeId}/{roomId}/{objectId}/{tourCreatorId}/{descriptionId}")
    ExtraDescription getGeneralDescription(@PathVariable long tourCreatorId, @PathVariable long placeId, @PathVariable long roomId, @PathVariable long objectId, @PathVariable long descriptionId) throws Exception {
        ExtraDescriptionKey descriptionKey = new ExtraDescriptionKey(descriptionId,tourCreatorId,objectId,placeId,roomId);
        return extraDescriptionService.getExtraDescriptionById(descriptionKey);
    }








}
