package com.example.tour.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import com.example.tour.models.Certification;

import javax.persistence.*;
import java.util.List;
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
    @JsonIgnore
    private Set<Tour> tours;

    @JsonIgnore
     @OneToMany(mappedBy = "tourCreator",cascade = CascadeType.ALL)
     private List<Certification> certifications;
}
