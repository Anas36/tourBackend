package com.example.tour.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "places")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Place {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;

    String type;

    String description;

    String email;

    String phone_number;

    String location;

    private boolean accepted;

    @OneToMany(mappedBy = "place")
    @JsonIgnore
    private Set<Room> rooms;

    @OneToMany(mappedBy = "placeId")
    @JsonIgnore
    private Set<Object> objects;




}