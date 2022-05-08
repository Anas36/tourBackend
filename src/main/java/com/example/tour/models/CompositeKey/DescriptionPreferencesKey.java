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
public class DescriptionPreferencesKey implements Serializable {

    @Column(name = "description_id")
    private long descriptionId;

    @Column(name = "tour_creator_id")
    private long tourCreatorId;

    @Column(name = "object_id",nullable=false)
    private long objectId;

    @Column(name = "place_id",nullable=false)
    private long placeId;

    @Column(name = "room_id",nullable=false)
    private long roomId;

    @Column(name = "preference_id",nullable=false)
    private long preferenceId;


    @Override
    public String toString() {
        return "descriptionPreferencesKey{" +
                "descriptionId=" + descriptionId +
                ", tourCreatorId=" + tourCreatorId +
                ", objectId=" + objectId +
                ", placeId=" + placeId +
                ", roomId=" + roomId +
                ", preferenceId=" + preferenceId +
                '}';
    }
}

