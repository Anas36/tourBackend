package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Room;
import com.example.tour.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping("/rooms")
    List<Room> getRooms()  {
        return roomService.getAllRooms();
    }

//    @GetMapping("place/{id}/rooms")
//    List<Room>  getRoom(@PathVariable long id)  {
//        return roomService.getRoomsByPlaceId(id);
//    }

    @PostMapping("/room")
    public String addRoom(@RequestBody Room room) throws Exception {
        System.out.println(room.toString());
        return roomService.saveRoom(room);
    }










}
