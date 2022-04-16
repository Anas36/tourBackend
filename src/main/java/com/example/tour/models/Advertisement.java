package com.example.tour.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "advertisements")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "advertiser_id",nullable = false)
    Advertiser advertiserId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id",nullable = false)
    Tour tourId;

    String description;

    String cover_photo;

}