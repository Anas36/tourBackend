package com.example.tour.data;

import com.example.tour.models.Tour;
import com.example.tour.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface TourRepo extends JpaRepository<Tour, Long> {

    @Query("select t from Tour t where t.tour_creator.id = :tour_creator_id")
    List<Tour> findToursByTourCreatorId(@Param("tour_creator_id") long id);
}
