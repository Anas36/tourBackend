//package com.example.tour.controllers;
//
////API Layer will be connected with the business logic layer (services)
//
//import com.example.tour.models.CompositeKey.QuestionKey;
//import com.example.tour.models.Question;
//import com.example.tour.services.QuestionService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class QuestionController {
//
//    private final QuestionService questionService;
//
//    public QuestionController(QuestionService questionService) {
//        this.questionService = questionService;
//    }
//
////    @GetMapping
////    List<Question> getQuestions()  {
////        return questionService.getAllQuestions();
////    }
//
//    @GetMapping("/tour/{tourId}/checkpoint/{checkpointId}/question")
//    Question getQuestion(@PathVariable long tourId, @PathVariable long checkpointId) throws Exception {
//        QuestionKey questionKey = new QuestionKey(checkpointId, tourId);
//        return questionService.getQuestionById(questionKey);
//    }
//
//    @PostMapping("checkpoint/question")
//    String addQuestion(@RequestBody Question question) throws Exception {
//        System.out.println(question.toString());
//        return questionService.saveQuestion(question);
//    }
//
//
//}
//
//
