package com.example.tour.models.CompositeKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TourRatingKey implements Serializable {
    @Column(name = "visitor_id")
    Long visitorId;

    @Column(name = "tour_id")
    Long tourId;



}
