package com.example.tour.models;


import com.example.tour.models.CompositeKey.CheckPointKey;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "checkPoints")
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

    @Column(name = "time")
    private int time;


    @ManyToOne
    @JoinColumn(name = "id",referencedColumnName = "id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "room_id",referencedColumnName="room_id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "place_id",referencedColumnName="place_id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "object_id",referencedColumnName="object_id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "tour_id",referencedColumnName="tour_id",insertable=false, updatable=false,nullable=false)
    @JsonBackReference
    private Checkpoint previousCheckPoint;

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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Object object;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Tour tour;


    @Override
    public String toString() {
        if(previousCheckPoint != null){
            return "Checkpoint{" +
                    "id=" + id +
                    ", objectId=" + objectId +
                    ", placeId=" + placeId +
                    ", roomId=" + roomId +
                    ", tourId=" + tourId +
                    ", previousCheckPoint=" + previousCheckPoint.getId() +
                    '}';}
        else
        {
            return "Checkpoint{" +
                "id=" + id +
                ", objectId=" + objectId +
                ", placeId=" + placeId +
                ", roomId=" + roomId +
                ", tourId=" + tourId +
                ", previousCheckPoint=" + null +
                '}';}

        }

}