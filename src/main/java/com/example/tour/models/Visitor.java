package com.example.tour.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "visitors")
@PrimaryKeyJoinColumn(name = "user_id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visitor extends User implements Serializable {

    @Column(name = "language")
    private String language;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH
    })
    @JoinTable(
            name = "visitor_preferences",
                joinColumns =  @JoinColumn(name = "visitor_id"),
                inverseJoinColumns = @JoinColumn(name = "preference_id"),
                uniqueConstraints = {
                            @UniqueConstraint(
                                    columnNames = {"visitor_id","preference_id"}
                            )
                        }
    )
    @JsonIgnore
    private Set<Preference> chosenPreferences =  new HashSet<>();

    @OneToMany
    @JsonIgnore
    private Set<Ticket> tickets = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "visitor")
    Set<TourRating> ratings;

    public void choosePreference(Preference preference) {
        chosenPreferences.add(preference);
    }
    public void chooseManyPreferences(Set<Preference> preferences) {  //Instead of Adding we will set a new set
        for (Preference preference : preferences)
        {
            if(chosenPreferences.contains(preference))
                continue;
            Preference p = new Preference(preference.getId(),preference.getPreference());
            chosenPreferences.add(preference);
        }
    }

    public String printChoosePreference() {
        StringBuilder result = new StringBuilder();
        for (Preference preference : chosenPreferences)
        {
            result.append("{").append(preference.toString()).append("}, ");
        }
        return result.toString();
    }

    public void setRole() {
        super.setRole("ROLE_VISITOR");
    }
}
