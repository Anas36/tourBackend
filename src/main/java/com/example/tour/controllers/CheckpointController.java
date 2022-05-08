package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.Checkpoint;
import com.example.tour.services.CheckpointService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("checkpoints")
public class CheckpointController {

    public CheckpointService checkpointService;

    public CheckpointController(CheckpointService checkpointService) {
        this.checkpointService = checkpointService;
    }

    @GetMapping
    List<Checkpoint> getCheckpoints()  {
        return checkpointService.getAllCheckpoints();
    }

    @PostMapping
    String addCheckPoint(@RequestBody Checkpoint checkpoint) throws Exception {
        System.out.println(checkpoint.toString());
        return checkpointService.saveCheckpoint(checkpoint);
    }


    @GetMapping("/tour/{tourId}")
    List<Checkpoint> getTourCheckpoint(@PathVariable long tourId)  {
        return checkpointService.getCheckpointByTourId(tourId);
    }

    @GetMapping("/tour/{tourId}/{checkpointId}")
    Checkpoint getTourCheckpointById(@PathVariable long tourId,@PathVariable long checkpointId)  {
        return checkpointService.getTourCheckpointById(tourId,checkpointId);
    }













}
