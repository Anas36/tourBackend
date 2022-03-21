package com.example.tour.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "quotes")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "quote_text")
    String quoteText;

    @Column(name = "author")
    String author;


}