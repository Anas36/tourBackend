package com.example.tour.models;


import com.example.tour.models.CompositeKey.QuestionKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(QuestionKey.class)
public class Question {

    @Id
    @Column(name = "check_point_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long checkPointId;

    @Id
    @Column(name = "object_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long objectId;

    @Id
    @Column(name = "place_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long placeId;

    @Id
    @Column(name = "room_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long roomId;

    @Id
    @Column(name = "tour_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long tourId;

    @Column(name = "question",nullable=false)
    private String question;

    @Column(name = "answer1",nullable=false)
    private String answer1;

    @Column(name = "answer2",nullable=false)
    private String answer2;

    @Column(name = "answer3",nullable=false)
    private String answer3;

    @Column(name = "correct_answer",nullable=false)
    private int correctAnswer;

    @Column(name = "fact",nullable=false)
    private String fact;

    @Column(name = "clue",nullable=false)
    private String clue;


    @ManyToOne
    @JoinColumn(name = "check_point_id",referencedColumnName = "id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "room_id",referencedColumnName="room_id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "place_id",referencedColumnName="place_id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "object_id",referencedColumnName="object_id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "tour_id",referencedColumnName="tour_id",insertable=false, updatable=false,nullable=false)
    private Checkpoint CheckPoint;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JsonIgnore
    private Place place;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "place_id",referencedColumnName="place_id",insertable=false, updatable=false,nullable=false)
    @JsonIgnore
    private Room room;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id",referencedColumnName="room_id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "place_id",referencedColumnName="place_id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "object_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JsonIgnore
    private Object object;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JsonIgnore
    private Tour tour;


    @Override
    public String toString() {
        return "Question{" +
                "checkPointId=" + checkPointId +
                ", objectId=" + objectId +
                ", placeId=" + placeId +
                ", roomId=" + roomId +
                ", tourId=" + tourId +
                ", CheckPoint=" + CheckPoint +
                ", place=" + place +
                ", room=" + room +
                ", object=" + object +
                ", tour=" + tour +
                '}';
    }
}