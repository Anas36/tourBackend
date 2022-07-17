package com.example.tour.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
@PrimaryKeyJoinColumn(name = "user_id")
@Getter
@Setter
@AllArgsConstructor
public class Admin extends User {

    public void setRole() {
        super.setRole("ROLE_ADMIN");
    }
}

