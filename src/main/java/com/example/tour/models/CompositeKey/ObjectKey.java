package com.example.tour.models.CompositeKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectKey implements Serializable {

    private long id;

//    RoomKey roomKey;  // corresponds to primary key type of Room

    @Column(name = "place_id",nullable=false)
    private long placeId;

    @Column(name = "room_id",nullable=false)
    private long roomId;

}

