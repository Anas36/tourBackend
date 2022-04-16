package com.example.tour.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "checkPoints")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@IdClass(ObjectKey.class)
public class Checkpoint {

    @Id
    private long id;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    private Place placeId;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    private Tour tourId;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "previous_check_point",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    private Checkpoint previous_check_point;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "place_id",referencedColumnName="place_id",insertable=false, updatable=false,nullable=false)
    private Room roomId;

//    @ManyToOne(optional=false,cascade = CascadeType.ALL)
//    @JoinColumn(name = "object_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
//    private Object object_id;

}