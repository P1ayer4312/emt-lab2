package com.emt.lab.emt_lab.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
public class Author {

    public Author(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    private Country country;
}
