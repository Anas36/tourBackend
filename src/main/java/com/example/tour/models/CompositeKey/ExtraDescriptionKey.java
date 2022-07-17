package com.example.tour.models.CompositeKey;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ExtraDescriptionKey implements Serializable {

    private long id;

    @Column(name = "tour_id")
    private long tourId;

    @Column(name = "check_point_id")
    private long checkPointId;

}

