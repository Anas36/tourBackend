package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.CompositeKey.ExtraDescriptionKey;
import com.example.tour.models.ExtraDescription;
import com.example.tour.services.ExtraDescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ExtraDescriptionController {

    private final ExtraDescriptionService extraDescriptionService;


//    @GetMapping
//    List<ExtraDescription> getExtraDescriptions()  {
//        return extraDescriptionService.getAllDescriptions();
//    }

    @PostMapping("descriptions/extra")
    String addExtraDescription(@RequestBody ExtraDescription description) throws Exception {
        System.out.println(description.toString());
        return extraDescriptionService.saveDescription(description);
    }

    @GetMapping("tour/{tourId}/checkPoint/{checkPointId}/description/{descriptionId}")
    ExtraDescription getGeneralDescription(@PathVariable long checkPointId, @PathVariable long tourId, @PathVariable long descriptionId) throws Exception {
        ExtraDescriptionKey descriptionKey = new ExtraDescriptionKey(descriptionId,tourId,checkPointId);
        return extraDescriptionService.getExtraDescriptionById(descriptionKey);
    }








}
