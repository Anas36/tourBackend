package com.example.tour.models;

import com.example.tour.models.CompositeKey.TourRatingKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
@Setter
@Getter
@NoArgsConstructor
public class TourRating {

    @EmbeddedId
    TourRatingKey id;

    @ManyToOne
    @MapsId("visitorId")
    @JoinColumn(name = "visitor_id")
    Visitor visitor;

    @ManyToOne
    @MapsId("tourId")
    @JoinColumn(name = "tour_id")
    Tour tour;

    @Column(name = "rating")
    int rating;

//    public TourRating(Visitor visitor, Tour tour, int rating) {
////        setId();
//        this.id = id;
//        this.visitor = visitor;
//        this.tour = tour;
//        this.rating = rating;
//
//    }

//    public void setId() {
//        this.id = new TourRatingKey(visitor.getId(), tour.getId());
//    }
}
