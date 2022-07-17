package com.example.tour.models.CompositeKey;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QuestionKey implements Serializable {

    @Column(name = "check_point_id",nullable=false)
    private long checkPointId;

    @Column(name = "tour_id",nullable=false)
    private long tourId;

}

