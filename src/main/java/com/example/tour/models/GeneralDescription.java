package com.example.tour.models;

import com.example.tour.annotations.ValidEmail;
import com.example.tour.models.CompositeKey.CheckPointKey;
import com.example.tour.models.CompositeKey.GeneralDescriptionKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "general_description")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(GeneralDescriptionKey.class)
public class GeneralDescription {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Id
    @Column(name = "authority_id",nullable=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long authorityId;


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

    @Column(name = "content")
    private String content;

    @Column(name = "language")
    private String language;

    @Column(name = "title")
    private String title;

    @Column(name = "content_type")
    private String content_type;

    @ManyToOne(optional=false,cascade = CascadeType.ALL)
    @JoinColumn(name = "authority_id",referencedColumnName="user_id",insertable=false, updatable=false,nullable=false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Authority authority;

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

    @Override
    public String toString() {
        return "GeneralDescription{" +
                "id=" + id +
                ", authorityId=" + authorityId +
                ", objectId=" + objectId +
                ", placeId=" + placeId +
                ", roomId=" + roomId +
                ", content='" + content + '\'' +
                ", language='" + language + '\'' +
                ", title='" + title + '\'' +
                ", content_type='" + content_type + '\'' +
                ", authority=" + authority +
                ", place=" + place +
                ", room=" + room +
                ", object=" + object +
                '}';
    }
}