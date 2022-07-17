package com.example.tour.services;

import com.example.tour.data.CheckpointRepo;
import com.example.tour.data.ObjectRepo;
import com.example.tour.data.PlaceRepo;
import com.example.tour.data.RoomRepo;
import com.example.tour.models.Checkpoint;
import com.example.tour.models.CompositeKey.CheckPointKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckpointService {

    private final CheckpointRepo checkpointRepo;
    private final ObjectRepo objectRepo;
    private final PlaceRepo placeRepo;
    private final RoomRepo roomRepo;


    public List<Checkpoint> getAllCheckpoints()
    {
        return checkpointRepo.findAll();
    }

    public List<Checkpoint> getCheckpointByTourId(long tourId) {
        return checkpointRepo.findCheckpointByTourIdOrderById(tourId);
    }
//
//    public void deleteCheckpointById(long id) {
//        if (!checkpointRepo.existsById(id)) {
//            throw new IllegalStateException("Checkpoint Not Exist");
//        } else {
//            checkpointRepo.deleteById(id);
//        }
//
//    }


    public String saveCheckpoint(Checkpoint checkpoint) throws Exception {
        if (checkpointRepo.existsById(new CheckPointKey(checkpoint.getId(), checkpoint.getTourId())))
            throw new Exception("this checkpoint id already exist");

        Checkpoint newCheckpoint = checkpointRepo.save(checkpoint);
        newCheckpoint.setPhoto();
        return "checkpoint with id: " + checkpoint.getId() + " been added";
    }

    public Checkpoint getTourCheckpointById(long tourId, long checkpointId) {
        return checkpointRepo.findCheckpointByTourIdAndId(tourId,checkpointId);
    }
}
