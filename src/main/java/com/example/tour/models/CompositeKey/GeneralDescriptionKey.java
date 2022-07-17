package com.example.tour.models.CompositeKey;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GeneralDescriptionKey implements Serializable {

    private long id;

    @Column(name = "authority_id")
    private long authorityId;

    @Column(name = "object_id",nullable=false)
    private long objectId;

    @Column(name = "place_id",nullable=false)
    private long placeId;

    @Column(name = "room_id",nullable=false)
    private long roomId;


    @Override
    public String toString() {
        return "DescriptionKey{" +
                "id=" + id +
                ", objectId=" + objectId +
                ", placeId=" + placeId +
                ", roomId=" + roomId +
                '}';
    }
}

