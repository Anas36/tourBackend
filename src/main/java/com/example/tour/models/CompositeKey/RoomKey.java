package com.example.tour.models.CompositeKey;

import com.example.tour.models.Place;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RoomKey implements Serializable {
    @Column(name = "id")
    long id;

    @Column(name = "place_id")
    long placeId;

}
