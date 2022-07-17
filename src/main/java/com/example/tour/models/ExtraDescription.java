package com.example.tour.models;

import com.example.tour.annotations.ValidEmail;
import com.example.tour.models.CompositeKey.CheckPointKey;
import com.example.tour.models.CompositeKey.ExtraDescriptionKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "extra_description")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ExtraDescriptionKey.class)
public class ExtraDescription {


    @Id
    private long id;

    @Id
    @Column(name = "tour_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long tourId;

    @Id
    @Column(name = "check_point_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long checkPointId;

    @Column(name = "content")
    private String content;

    @Column(name = "language")
    private String language;

    @Column(name = "title")
    private String title;

    @Column(name = "content_type")
    private String content_type;
//
//    @ManyToOne(optional=false,cascade = CascadeType.ALL)
//    @JoinColumn(name = "tour_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
//    @JsonIgnore
//    private Tour tour;
//
//    @ManyToOne
//    @JoinColumn(name = "check_point_id",referencedColumnName = "id",insertable=false, updatable=false,nullable=false)
//    @JoinColumn(name = "tour_id",referencedColumnName="tour_id",insertable=false, updatable=false,nullable=false)
//    private Checkpoint checkPoint;



}