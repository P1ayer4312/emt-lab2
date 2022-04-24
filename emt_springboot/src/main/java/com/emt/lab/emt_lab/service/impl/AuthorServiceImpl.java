package com.emt.lab.emt_lab.service.impl;

import com.emt.lab.emt_lab.model.Author;
import com.emt.lab.emt_lab.repository.AuthorRepository;
import com.emt.lab.emt_lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }
}
