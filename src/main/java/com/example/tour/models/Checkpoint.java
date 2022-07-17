package com.example.tour.models;


import com.example.tour.models.CompositeKey.CheckPointKey;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "check_points")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CheckPointKey.class)
public class Checkpoint {

    @Id
    @Column(name = "id")
    private long id;

    @Id
    @Column(name = "tour_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long tourId;

    @Column(name = "time")
    private int time;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "detailed_location")
    private String detailedLocation;

    @Column(name = "photo")
    private String photo;

    @Column(name = "category")
    private String category;


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


    public void setPhoto() {
        this.photo = "Tour_"+tourId+"_Checkpoint_"+id+"_Photo";;
    }

    @ManyToOne
    @JoinColumn(name = "id",referencedColumnName = "id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "tour_id",referencedColumnName="tour_id",insertable=false, updatable=false,nullable=false)
    @JsonBackReference
    private Checkpoint previousCheckPoint;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id",referencedColumnName="id",insertable=false, updatable=false)
    @JsonIgnore
    private Place place;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id",referencedColumnName="id",insertable=false, updatable=false)
    @JoinColumn(name = "place_id",referencedColumnName="place_id",insertable=false, updatable=false)
    @JsonIgnore
    private Room room;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id",referencedColumnName="room_id",insertable=false, updatable=false)
    @JoinColumn(name = "place_id",referencedColumnName="place_id",insertable=false, updatable=false)
    @JoinColumn(name = "object_id",referencedColumnName="id",insertable=false, updatable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Object object;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "tour_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    private Tour tour;



}