package com.example.tour.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "tour_creators")
@PrimaryKeyJoinColumn(name = "user_id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TourCreator extends User {
    @Column(name = "job")
    protected String job;

    @OneToMany(mappedBy="tour_creator")
    private Set<Tour> tours;
}
