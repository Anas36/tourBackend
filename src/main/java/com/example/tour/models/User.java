package com.example.tour.models;

import lombok.*;

import javax.persistence.*;

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
    String first_name;
    String last_name;
    String birth;
    String gender;
    String language;
    String email;
    String phone;
    String password;
    String address;


}