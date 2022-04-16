package com.example.tour.services;

//Business Logic layer

import com.example.tour.data.AdvertisementRepo;
import com.example.tour.models.Advertisement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {

    final AdvertisementRepo advertisementRepo;


    public AdvertisementService(AdvertisementRepo advertisementRepo) {
        this.advertisementRepo = advertisementRepo;
    }

    public List<Advertisement> getAllAdvertisements()
    {
        return advertisementRepo.findAll();
    }

    public Advertisement getAdvertisementById(long id) {
        return advertisementRepo.findById(id).orElse(null);
    }
}
