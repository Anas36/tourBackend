package com.example.tour.services;

import com.example.tour.data.PlaceRepo;
import com.example.tour.data.RoomRepo;
import com.example.tour.models.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepo roomRepo;
    private final PlaceRepo placeRepo;


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

        Room newRoom = roomRepo.save(room);

        return "room been added successfully";
    }
}
