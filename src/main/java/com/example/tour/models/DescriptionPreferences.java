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
    @Column(name = "preference_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long preferenceId;

    @Id
    @Column(name = "tour_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long tourId;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JsonIgnore
    private Tour tour;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "preference_id",referencedColumnName="id",insertable=false, updatable=false,nullable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Preference preference;




}