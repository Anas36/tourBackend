package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Checkpoint;
import com.example.tour.services.CheckpointService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CheckpointController {

    private final CheckpointService checkpointService;


//    @GetMapping
//    List<Checkpoint> getCheckpoints()  {
//        return checkpointService.getAllCheckpoints();
//    }

    @PostMapping("checkpoint")
    String addCheckPoint(@RequestBody Checkpoint checkpoint) throws Exception {
        System.out.println(checkpoint.toString());
        return checkpointService.saveCheckpoint(checkpoint);
    }


    @GetMapping("/tour/{tourId}/checkpoints")
    List<Checkpoint> getTourCheckpoint(@PathVariable long tourId)  {
        return checkpointService.getCheckpointByTourId(tourId);
    }

    @GetMapping("/tour/{tourId}/checkpoint/{checkpointId}")
    Checkpoint getTourCheckpointById(@PathVariable long tourId,@PathVariable long checkpointId)  {
        return checkpointService.getTourCheckpointById(tourId,checkpointId);
    }













}
