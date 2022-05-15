package com.example.tour.services;

import com.example.tour.data.*;
import com.example.tour.models.CompositeKey.QuestionKey;
import com.example.tour.models.Question;
import com.example.tour.models.CompositeKey.CheckPointKey;
import com.example.tour.models.CompositeKey.ObjectKey;
import com.example.tour.models.CompositeKey.RoomKey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    final QuestionRepo questionRepo;
    final CheckpointRepo checkpointRepo;
    final ObjectRepo objectRepo;
    final PlaceRepo placeRepo;
    final RoomRepo roomRepo;


    public QuestionService(QuestionRepo questionRepo, CheckpointRepo checkpointRepo, ObjectRepo objectRepo, PlaceRepo placeRepo, RoomRepo roomRepo) {
        this.questionRepo = questionRepo;
        this.checkpointRepo = checkpointRepo;
        this.objectRepo = objectRepo;
        this.placeRepo = placeRepo;
        this.roomRepo = roomRepo;
    }

    public List<Question> getAllQuestions()
    {
        return questionRepo.findAll();
    }


    public String saveQuestion(Question question) throws Exception {

        if (!placeRepo.existsById(question.getPlaceId()))
            throw new Exception("this place id doesn't exist");

        if (!roomRepo.existsById(new RoomKey(question.getRoomId(), question.getPlaceId())))
            throw new Exception("this room id doesn't exist");

        if (!objectRepo.existsById(new ObjectKey(question.getObjectId(), question.getPlaceId(), question.getRoomId())))
            throw new Exception("this object id doesn't exist");

        if (!checkpointRepo.existsById(new CheckPointKey(question.getCheckPointId(), question.getTourId(), question.getObjectId(), question.getPlaceId(), question.getRoomId())))
            throw new Exception("this CheckPoint id doesn't exist");


        questionRepo.save(question);
        return "question been added";
    }

    public Question getQuestionById(QuestionKey questionKey) {
        return questionRepo.getById(questionKey);
    }
}
