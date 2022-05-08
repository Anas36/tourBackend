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
    long id;

    @NotNull
    @NotEmpty
    String first_name;

    @NotNull
    @NotEmpty
    String last_name;

    @NotNull
    @NotEmpty
    String birth;

    @NotNull
    @NotEmpty
    String gender;

    @ValidEmail
    @NotNull
    @NotEmpty
    String email;

    String phone;

    @NotNull
    @NotEmpty
    String password;

    String address;

    String photo;


}