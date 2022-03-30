package com.example.tour.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "tours")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="tour_creator", nullable=false)
    TourCreator tour_creator;

    String name;

    String location;

    int distance;

    Timestamp departure_date;

    Timestamp arrival_date;

    String cover_photo;

    int max_participants;

    int cost;

    int visitors_joined;

    Date creation_date;

    String category;

    String description;

}
