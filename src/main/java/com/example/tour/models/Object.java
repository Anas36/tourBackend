package com.example.tour.models;


import com.example.tour.models.CompositeKey.ObjectKey;
import com.example.tour.models.CompositeKey.RoomKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "objects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ObjectKey.class)
public class Object {

    @Id
    @Column(name = "id")
    private long id;

    @Id
    @Column(name = "place_id",nullable=false)
    private long placeId;

    @Id
    @Column(name = "room_id",nullable=false)
    private long roomId;

    @Column(name = "name")
    private String name;

    @Column(name = "cover_photo")
    private String coverPhoto;

//    @Id
//    RoomKey roomKey;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Place place;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "place_id",referencedColumnName="place_id",insertable=false, updatable=false,nullable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Room room;

//    public void setRoomKey(RoomKey roomKey) {
//        this.roomKey = roomKey;
//        this.roomKey.setId(roomId.getId());
//        this.roomKey.setPlaceId(placeId.getId());
//
//    }

    @Override
    public String toString() {
        return "Object{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coverPhoto='" + coverPhoto + '\'' +
                ", roomKey=" + room +
                ", placeId=" + placeId +
                ", roomId=" + room +
                '}';
    }
}