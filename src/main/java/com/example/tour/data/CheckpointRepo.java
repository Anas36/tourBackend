package com.example.tour.data;

import com.example.tour.models.Checkpoint;
import com.example.tour.models.CompositeKey.CheckPointKey;
import com.example.tour.models.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CheckpointRepo extends JpaRepository<Checkpoint, CheckPointKey> {

    List<Checkpoint> findCheckpointByTourIdOrderById(long tourId);

    Checkpoint findCheckpointByTourIdAndId(long tourId,long checkpointId);



}
