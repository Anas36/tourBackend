package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Advertiser;
import com.example.tour.services.AdvertiserService;
import com.example.tour.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("advertisers")
@RequiredArgsConstructor
public class AdvertiserController {

    private final AdvertiserService advertiserService;
    private final UserService userService;


    @PostMapping()
    Advertiser addAdvertiser(@RequestBody Advertiser advertiser) {
        advertiser.setRole();
        return (Advertiser) userService.saveUser(advertiser);
    }
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
