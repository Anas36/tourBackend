package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Advertisement;
import com.example.tour.services.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("advertisements")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;


    @GetMapping
    List<Advertisement> getAdvertisements()  {
        return advertisementService.getAllAdvertisements();
    }
    @GetMapping("/{id}")
    Advertisement getAdvertisement(@PathVariable long id)  {
        return advertisementService.getAdvertisementById(id);
    }








}
