package com.example.tour.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

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
    @JoinColumn(name="tour_creator")
    private TourCreator tour_creator;

    private String name;

    private String location;

    private int distance;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp departure_date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp arrival_date;

    private String cover_photo;

    private int max_participants;

    private int cost;

    private int visitors_joined;

    private Date creation_date = new Date();

    private String category;

    private String description;

    @OneToMany(mappedBy = "tour")
    @JsonIgnore
    private Set<TourRating> ratings;

    @OneToMany(mappedBy = "tourId")
    @JsonIgnore
    List<Advertisement> advertisements;

    @PrePersist
    private void onCreate() {
        creation_date = new Date();
    }

}
