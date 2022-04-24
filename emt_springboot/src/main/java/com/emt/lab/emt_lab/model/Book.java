package com.emt.lab.emt_lab.model;

import com.emt.lab.emt_lab.model.enums.Category;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
public class Book {
    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

}
