//package com.example.tour.services;
//
//import com.example.tour.data.*;
//import com.example.tour.models.CompositeKey.QuestionKey;
//import com.example.tour.models.Question;
//import com.example.tour.models.CompositeKey.CheckPointKey;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class QuestionService {
//
//    private final QuestionRepo questionRepo;
//    private final CheckpointRepo checkpointRepo;
//    private final ObjectRepo objectRepo;
//    private final PlaceRepo placeRepo;
//    private final RoomRepo roomRepo;
//
//
//    public List<Question> getAllQuestions()
//    {
//        return questionRepo.findAll();
//    }
//
//
//    public String saveQuestion(Question question) throws Exception {
//        questionRepo.save(question);
//        return "question been added";
//    }
//
//    public Question getQuestionById(QuestionKey questionKey) throws Exception {
//        CheckPointKey checkPointKey = new CheckPointKey(questionKey.getCheckPointId(),questionKey.getTourId());
//        if (!checkpointRepo.existsById(checkPointKey))
//            throw new Exception("this checkpoint dosn't exist");
//        return questionRepo.getById(questionKey);
//    }
//}
