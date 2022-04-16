package com.example.tour.services;

import com.example.tour.data.ObjectRepo;
import com.example.tour.data.PlaceRepo;
import com.example.tour.data.RoomRepo;
import com.example.tour.models.CompositeKey.RoomKey;
import com.example.tour.models.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectService {
    final ObjectRepo objectRepo;
    final PlaceRepo placeRepo;
    final RoomRepo roomRepo;


    @Autowired
    public ObjectService(ObjectRepo objectRepo, PlaceRepo placeRepo, RoomRepo roomRepo) {
        this.objectRepo = objectRepo;
        this.placeRepo = placeRepo;
        this.roomRepo = roomRepo;
    }



    public List<Object> getAllObjects()
    {
        return objectRepo.findAll();

    }

//    public List<Object> getObjectsByPlaceId(long placeID, long roomID) {
//        return objectRepo.getObjectsByPlaceId(placeID,roomID);
//    }
//
//    public void deleteObjectById(long id) {
//        if (!objectRepo.existsById(id)) {
//            throw new IllegalStateException("Object Not Exist");
//        } else {
//            objectRepo.deleteById(id);
//        }
//
//    }

    public String saveObject(Object object) throws Exception {
        if(!placeRepo.existsById(object.getPlaceId()))
            throw new Exception("there is no place with this id");
        if(!roomRepo.existsById(new RoomKey(object.getRoomId(),object.getPlaceId())))
            throw new Exception("there is no room with this id");
        objectRepo.save(object);
        return "object been added successfully";
    }
}
