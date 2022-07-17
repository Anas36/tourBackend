package com.example.tour.data;

import com.example.tour.models.CompositeKey.ExtraDescriptionKey;
import com.example.tour.models.ExtraDescription;
import com.example.tour.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtraDescriptionRepo extends JpaRepository<ExtraDescription, ExtraDescriptionKey> {

//    @Query("SELECT e FROM ExtraDescription e WHERE e.objectId = :object_id AND e.placeId = :place_id AND e.roomId = :room_id")
//    List<ExtraDescription> getObjectDescriptions(@Param("object_id") long id, @Param("room_id") long roomId, @Param("place_id") long placeId);
}
