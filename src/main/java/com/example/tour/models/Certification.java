package com.example.tour.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "certification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="tour_creator_id",referencedColumnName = "user_id")
    private TourCreator tourCreator;

    @ManyToOne
    @JoinColumn(name="authority_id",referencedColumnName = "user_id")
    private Authority authority;

    private boolean acceptance;

    @Column(name = "url")
    private String content;


}
