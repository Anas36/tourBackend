package com.example.tour.data;

import com.example.tour.models.Advertisement;
import com.example.tour.models.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepo extends JpaRepository<Advertisement, Long> {

}
