package com.example.tour.services;

import com.example.tour.data.CheckpointRepo;
import com.example.tour.data.ObjectRepo;
import com.example.tour.data.PlaceRepo;
import com.example.tour.data.RoomRepo;
import com.example.tour.models.Checkpoint;
import com.example.tour.models.CompositeKey.CheckPointKey;
import com.example.tour.models.CompositeKey.ObjectKey;
import com.example.tour.models.CompositeKey.RoomKey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckpointService {
    final CheckpointRepo checkpointRepo;
    final ObjectRepo objectRepo;
    final PlaceRepo placeRepo;
    final RoomRepo roomRepo;


    public CheckpointService(CheckpointRepo checkpointRepo, ObjectRepo objectRepo, PlaceRepo placeRepo, RoomRepo roomRepo) {
        this.checkpointRepo = checkpointRepo;
        this.objectRepo = objectRepo;
        this.placeRepo = placeRepo;
        this.roomRepo = roomRepo;
    }

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

        if (!placeRepo.existsById(checkpoint.getPlaceId()))
            throw new Exception("this place id doesn't exist");

        if (!roomRepo.existsById(new RoomKey(checkpoint.getRoomId(), checkpoint.getPlaceId())))
            throw new Exception("this room id doesn't exist");

        if (!objectRepo.existsById(new ObjectKey(checkpoint.getObjectId(), checkpoint.getPlaceId(), checkpoint.getRoomId())))
            throw new Exception("this object id doesn't exist");

        if (checkpointRepo.existsById(new CheckPointKey(checkpoint.getId(), checkpoint.getTourId(), checkpoint.getObjectId(), checkpoint.getPlaceId(), checkpoint.getRoomId())))
            throw new Exception("this checkpoint id already exist");


        checkpointRepo.save(checkpoint);
        return "checkpoint with id: " + checkpoint.getId() + " been added";
    }

    public Checkpoint getTourCheckpointById(long tourId, long checkpointId) {
        return checkpointRepo.findCheckpointByTourIdAndId(tourId,checkpointId);
    }
}
