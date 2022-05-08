package com.example.tour.models;

import com.example.tour.models.CompositeKey.RoomKey;
import com.example.tour.models.CompositeKey.TourRatingKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(RoomKey.class)
public class Room  {

    @Id
    @Column(name = "id")
    private long id;

    @Id
    @Column(name = "place_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long placeId;

    private String name;

    private String location;

    private String description;

    @ManyToOne(optional=false)
    @JoinColumn(name = "place_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Place place;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private Set<Object> objects;

    public void setPlace(Place place) {
        this.place = place;
        this.placeId = place.getId();
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", placeID=" + placeId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}