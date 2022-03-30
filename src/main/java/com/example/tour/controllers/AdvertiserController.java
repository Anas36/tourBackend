package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.User;
import com.example.tour.models.Advertiser;
import com.example.tour.services.AdvertiserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("advertisers")
public class AdvertiserController {

    public AdvertiserService advertiserService;

    public AdvertiserController(AdvertiserService advertiserService) {
        this.advertiserService = advertiserService;
    }

    @PostMapping()
    void addAdvertiser(@RequestBody Advertiser advertiser) {advertiserService.saveAdvertiser(advertiser);}
    @GetMapping
    List<Advertiser> getAdvertisers()  {
        return advertiserService.getAllAdvertisers();
    }
    @GetMapping("/{id}")
    Advertiser getAdvertiser(@PathVariable long id)  {
        return advertiserService.getAdvertiserById(id);
    }
    @DeleteMapping("/{id}")
    void removeAdvertiser(@PathVariable long id)  {
        advertiserService.deleteAdvertiserById(id);
    }



}
