package com.example.tour.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "visitors")
@PrimaryKeyJoinColumn(name = "user_id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visitor extends User {
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
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

    public void choosePreference(Preference preference) {
        chosenPreferences.add(preference);
    }
    public void chooseManyPreferences(Set<Preference> preferences) {
        for (Preference preference : preferences)
        {
            Preference p = new Preference(preference.getId(),preference.getPreference());
            chosenPreferences.add(preference);
        }
    }

    public String printChoosePreference() {
        String result = "";
        for (Preference preference : chosenPreferences)
        {
            result += "{"+preference.toString()+"}, ";
        }
        return result;
    }



    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birth='" + birth + '\'' +
                ", gender='" + gender + '\'' +
                ", language='" + language + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
//                ", chosenPreferences=" + printChoosePreference() +
                '}';
    }

}