package com.example.tour.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private long id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String description;

    @Column
    private String email;

    @Column
    private String phone_number;

    @Column
    private String location;

    @Column
    private boolean accepted;

    @OneToMany(mappedBy = "place")
    @JsonIgnore
    private Set<Room> rooms;

    @OneToMany(mappedBy = "placeId")
    @JsonIgnore
    private Set<Object> objects;




}