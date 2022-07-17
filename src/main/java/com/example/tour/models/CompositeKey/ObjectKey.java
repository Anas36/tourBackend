package com.example.tour.models.CompositeKey;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ObjectKey implements Serializable {

    private long id;

//    RoomKey roomKey;  // corresponds to primary key type of Room

    @Column(name = "place_id",nullable=false)
    private long placeId;

    @Column(name = "room_id",nullable=false)
    private long roomId;

}

