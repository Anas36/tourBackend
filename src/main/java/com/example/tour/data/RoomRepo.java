package com.example.tour.data;

import com.example.tour.models.CompositeKey.RoomKey;
import com.example.tour.models.Place;
import com.example.tour.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface RoomRepo extends JpaRepository<Room, RoomKey> {

//    @Query("SELECT r FROM Room r WHERE r.place.id = :place_id")
//    List<Room> getRoomsByPlaceId(@Param("place_id") long placeId);
}
