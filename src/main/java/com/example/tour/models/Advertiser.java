package com.example.tour.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "advertisers")
@PrimaryKeyJoinColumn(name = "user_id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Advertiser extends User {

    @OneToMany(mappedBy = "advertiserId")
    @JsonIgnore
    private List<Advertisement> advertisements;

    public void setRole() {
        super.setRole("ROLE_ADVERTISER");
    }
}

