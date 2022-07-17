package com.example.tour.data;

import com.example.tour.models.CompositeKey.RoomKey;
import com.example.tour.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room, RoomKey> {

//    @Query("SELECT r FROM Room r WHERE r.place.id = :place_id")
//    List<Room> getRoomsByPlaceId(@Param("place_id") long placeId);
}
