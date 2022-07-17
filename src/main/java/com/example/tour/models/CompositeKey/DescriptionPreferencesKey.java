package com.example.tour.models.CompositeKey;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DescriptionPreferencesKey implements Serializable {

    @Column(name = "tour_id")
    private long tourId;

    @Column(name = "preference_id",nullable=false)
    private long preferenceId;

    @Override
    public String toString() {
        return "DescriptionPreferencesKey{" +
                "tourId=" + tourId +
                ", preferenceId=" + preferenceId +
                '}';
    }
}

