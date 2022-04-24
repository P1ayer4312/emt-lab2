package com.emt.lab.emt_lab.service;

import com.emt.lab.emt_lab.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book saveBook(Book newBook);
    void removeBookById(Long id);
    Book getBookById(Long id);
}
