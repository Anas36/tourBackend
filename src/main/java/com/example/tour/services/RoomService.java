package com.example.tour.services;

import com.example.tour.data.PlaceRepo;
import com.example.tour.data.RoomRepo;
import com.example.tour.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    final RoomRepo roomRepo;
    final PlaceRepo placeRepo;


    @Autowired
    public RoomService(RoomRepo roomRepo, PlaceRepo placeRepo) {
        this.roomRepo = roomRepo;
        this.placeRepo = placeRepo;
    }

    public List<Room> getAllRooms() {
        return roomRepo.findAll();

    }

//    public List<Room> getRoomsByPlaceId(long placeId) {
//        return roomRepo.getRoomsByPlaceId(placeId);
//    }
//
//    public void deleteRoomById(long id) {
//        if (!roomRepo.existsById(id)) {
//            throw new IllegalStateException("Room Not Exist");
//        } else {
//            roomRepo.deleteById(id);
//        }
//
//    }

    public String saveRoom(Room room) throws Exception {

        if (!placeRepo.existsById(room.getPlaceId()))
            throw new Exception("there is no place with this id");

        roomRepo.save(room);

        return "room been added successfully";
    }
}
