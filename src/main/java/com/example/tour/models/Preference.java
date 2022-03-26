package com.example.tour.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "preferences")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String preference;
    @ManyToMany(mappedBy = "chosenPreferences")
    @JsonIgnore
    private Set<Visitor> followers =  new HashSet<>();

    public Preference(long id, String preference) {
        this.id = id;
        this.preference = preference;
    }

    public void addVisitor(Visitor visitor) {
        followers.add(visitor);
    }

    @Override
    public String toString() {
        return "Preference{" +
                "id=" + id +
                ", preference='" + preference + '\'' +
                ", followers=" + followers +
                '}';
    }
}
