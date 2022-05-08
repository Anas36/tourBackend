package com.example.tour.models;

import com.example.tour.models.CompositeKey.DescriptionPreferencesKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "description_preferences")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(DescriptionPreferencesKey.class)
public class DescriptionPreferences {


    @Id
    long descriptionId;

    @Id
    @Column(name = "preference_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    long preferenceId;

    @Id
    @Column(name = "tour_creator_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long tourCreatorId;

    @Id
    @Column(name = "object_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long objectId;

    @Id
    @Column(name = "place_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long placeId;

    @Id
    @Column(name = "room_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long roomId;


    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id",referencedColumnName="room_id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "place_id",referencedColumnName="place_id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "tour_creator_id",referencedColumnName="tour_creator_id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "object_id",referencedColumnName="object_id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "description_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ExtraDescription extraDescription;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_creator_id",referencedColumnName="user_id",insertable=false, updatable=false,nullable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private TourCreator tourCreator;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "preference_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Preference preference;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JsonIgnore
    private Place place;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "place_id",referencedColumnName="place_id",insertable=false, updatable=false,nullable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Room room;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id",referencedColumnName="room_id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "place_id",referencedColumnName="place_id",insertable=false, updatable=false,nullable=false)
    @JoinColumn(name = "object_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Object object;


}