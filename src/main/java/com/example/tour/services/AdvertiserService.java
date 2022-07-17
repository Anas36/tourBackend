package com.example.tour.services;

import com.example.tour.data.AdvertiserRepo;
import com.example.tour.models.User;
import com.example.tour.models.Advertiser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertiserService {

    private final AdvertiserRepo advertiserRepo;



    public List<Advertiser> getAllAdvertisers()
    {
        return advertiserRepo.findAll();

    }

    public Advertiser getAdvertiserById(long id) {
        return advertiserRepo.findById(id).orElse(null);
    }

    public void deleteAdvertiserById(long id) {
        if (!advertiserRepo.existsById(id)) {
            throw new IllegalStateException("Advertiser Not Exist");
        } else {
            advertiserRepo.deleteById(id);
        }

    }

    public boolean advertiseryExists(String email) {
        return advertiserRepo.existsByEmail(email);
    }

    public void saveAdvertiser(Advertiser advertiser) {
        advertiserRepo.save(advertiser);
    }
}
