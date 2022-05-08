package com.example.tour.models.CompositeKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CheckPointKey implements Serializable {

    private long id;

    @Column(name = "tour_id",nullable=false)
    private long tourId;

    @Column(name = "object_id",nullable=false)
    private long objectId;

    @Column(name = "place_id",nullable=false)
    private long placeId;

    @Column(name = "room_id",nullable=false)
    private long roomId;

}

