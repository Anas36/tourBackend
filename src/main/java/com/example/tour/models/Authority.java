package com.example.tour.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authorities")
@PrimaryKeyJoinColumn(name = "user_id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authority extends User {

    @JsonIgnore
    @OneToMany(mappedBy = "authority",cascade = CascadeType.ALL)
    private List<Certification> acceptedCertifications;

    public void setRole() {
        super.setRole("ROLE_AUTHORITY");
    }
}

