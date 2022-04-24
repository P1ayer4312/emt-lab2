package com.emt.lab.emt_lab.web;

import com.emt.lab.emt_lab.model.Book;
import com.emt.lab.emt_lab.model.Country;
import com.emt.lab.emt_lab.service.BookService;
import com.emt.lab.emt_lab.service.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class homeController {

    private final CountryService countryService;
    private final BookService bookService;
    public homeController(CountryService countryService, BookService bookService) {
        this.countryService = countryService;
        this.bookService = bookService;
    }

    @GetMapping
    public List<Country> getAll() {
        return countryService.getAllCountries();
    }

    @GetMapping("book")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
