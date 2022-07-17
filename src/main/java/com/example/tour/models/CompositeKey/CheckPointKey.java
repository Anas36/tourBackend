package com.example.tour.models.CompositeKey;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CheckPointKey implements Serializable {

    private long id;

    @Column(name = "tour_id",nullable=false)
    private long tourId;

}

