package com.example.tour.data;

import com.example.tour.data.selectInterface.AvgTourCreatorRating;
import com.example.tour.data.selectInterface.AvgTourRating;
import com.example.tour.models.CompositeKey.TourRatingKey;
import com.example.tour.models.Tour;
import com.example.tour.models.TourRating;
import net.minidev.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRatingRepo extends JpaRepository<TourRating, TourRatingKey> {

    @Query("SELECT  tr.visitor.first_name,tr.visitor.last_name,tr.rating FROM TourRating tr WHERE tr.tour.id= :tour_id")
    List<Object> findByTourId(@Param("tour_id") long tourID);

    @Query("SELECT  AVG(tr.rating) FROM TourRating tr WHERE tr.tour.tour_creator.id = :tour_creator_id")
    Double getTourCreatorRating(@Param("tour_creator_id") long tourCreatorId);

    @Query("SELECT tr.tour.id AS tour_id,concat(tr.tour.tour_creator.first_name,' ' , tr.tour.tour_creator.last_name) AS tour_creator_name,tr.tour.cover_photo AS cover_photo,tr.tour.description AS description, AVG(tr.rating) AS avg_rating FROM TourRating tr group by tr.tour ORDER BY avg_rating DESC ")
    List<AvgTourRating> findTopTour();

    @Query("SELECT tr.tour.tour_creator.id AS tour_creator_id,concat(tr.tour.tour_creator.first_name,' ' , tr.tour.tour_creator.last_name) AS tour_creator_name,tr.tour.tour_creator.photo AS cover_photo, AVG(tr.rating) AS avg_rating FROM TourRating tr group by tr.tour.tour_creator ORDER BY avg_rating DESC ")
    List<AvgTourCreatorRating> findTopTourCreator();




}
