package com.example.tour.data;

import com.example.tour.models.CompositeKey.TourRatingKey;
import com.example.tour.models.TourRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRatingRepo extends JpaRepository<TourRating, TourRatingKey> {

    @Query("SELECT  tr.visitor.first_name,tr.visitor.last_name,tr.rating FROM TourRating tr WHERE tr.tour.id= :tour_id")
    public List<Object> findByTourId(@Param("tour_id") long tourID);

    @Query("SELECT  AVG(tr.rating) FROM TourRating tr WHERE tr.tour.tour_creator.id = :tour_creator_id")
    Float getTourCreatorRating(@Param("tour_creator_id") long tourCreatorId);
}
