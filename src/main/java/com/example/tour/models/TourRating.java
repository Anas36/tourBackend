package com.example.tour.models;

import com.example.tour.models.CompositeKey.TourRatingKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
@Setter
@Getter
@NoArgsConstructor
@IdClass(TourRatingKey.class)
public class TourRating {

    @Id
    @Column(name = "visitor_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long visitorId;

    @Id
    @Column(name = "tour_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long tourId;

    @ManyToOne
    @JoinColumn(name = "visitor_id",insertable=false, updatable=false,nullable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Visitor visitor;

    @ManyToOne
    @JoinColumn(name = "tour_id",insertable=false, updatable=false,nullable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Tour tour;

    @Column(name = "rating")
    private int rating;

    @Column(name = "recommended_rating")
    private int recommendedRating;

}
