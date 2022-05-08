package com.example.tour.data;

import com.example.tour.models.CompositeKey.GeneralDescriptionKey;
import com.example.tour.models.CompositeKey.ObjectKey;
import com.example.tour.models.GeneralDescription;
import com.example.tour.models.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneralDescriptionRepo extends JpaRepository<GeneralDescription, GeneralDescriptionKey>{

    @Query("SELECT g FROM GeneralDescription g WHERE g.objectId = :object_id AND g.placeId = :place_id AND g.roomId = :room_id")
    List<GeneralDescription> getObjectDescriptions(@Param("object_id") long id,@Param("room_id") long roomId,@Param("place_id") long placeId);
}
