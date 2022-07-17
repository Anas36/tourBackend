//package com.example.tour.models;
//
//
//import com.example.tour.models.CompositeKey.QuestionKey;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "questions")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@IdClass(QuestionKey.class)
//public class Question {
//
//    @Id
//    @Column(name = "check_point_id")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private long checkPointId;
//
//    @Id
//    @Column(name = "tour_id",nullable=false)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private long tourId;
//
//    @Column(name = "question",nullable=false)
//    private String question;
//
//    @Column(name = "answer1",nullable=false)
//    private String answer1;
//
//    @Column(name = "answer2",nullable=false)
//    private String answer2;
//
//    @Column(name = "answer3",nullable=false)
//    private String answer3;
//
//    @Column(name = "correct_answer",nullable=false)
//    private int correctAnswer;
//
//    @Column(name = "fact",nullable=false)
//    private String fact;
//
//    @Column(name = "clue",nullable=false)
//    private String clue;
//
////
////    @ManyToOne
////    @JoinColumn(name = "check_point_id",referencedColumnName = "id",insertable=false, updatable=false,nullable=false)
////    @JoinColumn(name = "tour_id",referencedColumnName="tour_id",insertable=false, updatable=false,nullable=false)
////    private Checkpoint CheckPoint;
////
////    @ManyToOne(optional=false,cascade = CascadeType.ALL)
////    @JoinColumn(name = "tour_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
////    @JsonIgnore
////    private Tour tour;
//
//
//    @Override
//    public String toString() {
//        return "Question{" +
//                "checkPointId=" + checkPointId +
//                ", tourId=" + tourId +
//                ", question='" + question + '\'' +
//                ", answer1='" + answer1 + '\'' +
//                ", answer2='" + answer2 + '\'' +
//                ", answer3='" + answer3 + '\'' +
//                ", correctAnswer=" + correctAnswer +
//                ", fact='" + fact + '\'' +
//                ", clue='" + clue + '\'' +
//                '}';
//    }
//}