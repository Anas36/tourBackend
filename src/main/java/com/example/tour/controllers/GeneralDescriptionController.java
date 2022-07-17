package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.CompositeKey.GeneralDescriptionKey;
import com.example.tour.models.GeneralDescription;
import com.example.tour.services.GeneralDescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("description/general")
@RequiredArgsConstructor
public class GeneralDescriptionController {

    private final GeneralDescriptionService generalDescriptionService;

    @GetMapping
    List<GeneralDescription> getGeneralDescriptions()  {
        return generalDescriptionService.getAllGeneralDescriptions();
    }

    @PostMapping
    String addGeneralDescription(@RequestBody GeneralDescription generalDescription) throws Exception {
        System.out.println(generalDescription.toString());
        return generalDescriptionService.saveDescription(generalDescription);
    }
    @GetMapping("/{placeId}/{roomId}/{objectId}/{authorityId}/{descriptionId}")
    GeneralDescription getGeneralDescription(@PathVariable long authorityId,@PathVariable long placeId,@PathVariable long roomId,@PathVariable long objectId,@PathVariable long descriptionId) throws Exception {
        GeneralDescriptionKey descriptionKey = new GeneralDescriptionKey(descriptionId,authorityId,objectId,placeId,roomId);
        return generalDescriptionService.getGeneralDescriptionById(descriptionKey);
    }


}
