package com.example.tour.models.CompositeKey;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TourRatingKey implements Serializable {
    @Column(name = "visitor_id")
    Long visitorId;

    @Column(name = "tour_id")
    Long tourId;



}
