package com.example.tour.controllers;

//API Layer will be connected with the business logic layer (services)

import com.example.tour.models.CompositeKey.QuestionKey;
import com.example.tour.models.Question;
import com.example.tour.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    public QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

//    @GetMapping
//    List<Question> getQuestions()  {
//        return questionService.getAllQuestions();
//    }

    @GetMapping("place/{placeId}/room/{roomId}/object/{objectId}/tour/{tourId}/checkpoint/{checkpointId}")
    Question getQuestion(@PathVariable long tourId, @PathVariable long checkpointId, @PathVariable long objectId, @PathVariable long roomId, @PathVariable long placeId) {
        QuestionKey questionKey = new QuestionKey(checkpointId, tourId, objectId, placeId, roomId);
        return questionService.getQuestionById(questionKey);
    }

    @PostMapping
    String addCheckPoint(@RequestBody Question question) throws Exception {
        System.out.println(question.toString());
        return questionService.saveQuestion(question);
    }


}


