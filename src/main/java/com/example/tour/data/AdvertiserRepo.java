package com.example.tour.data;

import com.example.tour.models.Advertiser;
import com.example.tour.models.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiserRepo extends JpaRepository<Advertiser, Long>{

}
