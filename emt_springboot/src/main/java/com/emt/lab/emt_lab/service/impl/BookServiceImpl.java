package com.emt.lab.emt_lab.service.impl;

import com.emt.lab.emt_lab.model.Book;
import com.emt.lab.emt_lab.repository.AuthorRepository;
import com.emt.lab.emt_lab.repository.BookRepository;
import com.emt.lab.emt_lab.repository.CountryRepository;
import com.emt.lab.emt_lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    @Override
    public void removeBookById(Long id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.deleteById(id);
        authorRepository.deleteById(book.getAuthor().getId());
        countryRepository.deleteById(book.getAuthor().getCountry().getId());
    }

    @Override
    public Book getBookById(Long id) {
        Optional temp = bookRepository.findById(id);
        if (temp.isPresent())
            return bookRepository.findById(id).get();
        return null;
    }
}
