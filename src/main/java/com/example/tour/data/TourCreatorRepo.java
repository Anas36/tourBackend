package com.example.tour.data;

import com.example.tour.data.selectInterface.TourCreatorProfile;
import com.example.tour.models.Object;
import net.minidev.json.JSONObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TourCreatorRepo extends UserRepo{

    @Query("select t from TourCreator t WHERE t.id = :tour_creator_id")
    TourCreatorProfile findTourCreatorProfile(@Param("tour_creator_id") long id);
}
