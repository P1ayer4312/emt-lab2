package com.emt.lab.emt_lab.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "country")
@NoArgsConstructor
public class Country {

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String continent;

}
