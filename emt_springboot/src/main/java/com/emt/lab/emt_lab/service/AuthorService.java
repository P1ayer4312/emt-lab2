package com.emt.lab.emt_lab.service;

import com.emt.lab.emt_lab.model.Author;

import java.util.List;

public interface AuthorService {
    Author saveAuthor(Author author);
    List<Author> getAllAuthors();
}
