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
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "advertiser_id",nullable = false)
    private Advertiser advertiserId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id",nullable = false)
    private Tour tourId;

    private String description;

    private String cover_photo;

    public void setCover_photo() {
        this.cover_photo  = "Advertisement_"+id+"_Cover_Photo";
    }
}