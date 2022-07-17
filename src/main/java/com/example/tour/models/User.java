package com.example.tour.models;

import com.example.tour.annotations.ValidEmail;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    private String first_name;

    @NotNull
    @NotEmpty
    private String last_name;

    @NotNull
    @NotEmpty
    private String birth;

    @NotNull
    @NotEmpty
    private String gender;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

    private String phone;

    @NotNull
    @NotEmpty
    private String password;

    private String address;

    private String photo = "User_"+id+"_Photo";

    @JoinColumn(name = "role")
    private String role;


    public void setPhoto() {
        this.photo = "User_"+id+"_Photo";
    }


}