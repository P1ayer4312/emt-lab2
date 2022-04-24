package com.emt.lab.emt_lab.web.rest;

import com.emt.lab.emt_lab.model.Author;
import com.emt.lab.emt_lab.model.Book;
import com.emt.lab.emt_lab.model.Country;
import com.emt.lab.emt_lab.model.enums.Category;
import com.emt.lab.emt_lab.service.AuthorService;
import com.emt.lab.emt_lab.service.BookService;
import com.emt.lab.emt_lab.service.CountryService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class booksController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;
    public booksController(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/getPage")
    public String getPage() {
        return "TODO: pagination";
    }

    @PostMapping("/createBook")
    public String createBook(
            @RequestParam String name,
            @RequestParam Category category,
            @RequestParam String authorName,
            @RequestParam String countryName,
            @RequestParam String continent,
            @RequestParam Integer availableCopies
    ) {
        Country country = countryService.saveCountry(new Country(countryName, continent));
        Author author = authorService.saveAuthor(new Author(authorName, country));
        bookService.saveBook(new Book(name, category, author, availableCopies));
        return "redirect:/";
    }

    @PostMapping("/editBook")
    public String editBook(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam Category category,
            @RequestParam String authorName,
            @RequestParam String countryName,
            @RequestParam String continent,
            @RequestParam Integer availableCopies
    ) {
        Book book = bookService.getBookById(id);
        Author author = book.getAuthor();
        Country country = book.getAuthor().getCountry();

        book.setName(name);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);
        author.setName(authorName);
        country.setName(countryName);
        country.setContinent(continent);

        book.setCategory(category);
        book.setAuthor(author);
        bookService.saveBook(book);

        return "";
    }

    @GetMapping("/editCountry") // FIX THIS
    public String editCountry() {
        Country country = countryService.getCountryById((long) 32);
        country.setName("burek55");
        country.setContinent("burek66");
        countryService.saveCountry(country);
        return "";
    }

    @PutMapping("/markAsTaken/{id}")
    public String markAsTaken(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookService.saveBook(book);
        return "";
    }

    @PostMapping("/removeBookById/{id}")
    public String removeBookById(@PathVariable Long id) {
        bookService.removeBookById(id);
        return "";
    }

    @GetMapping("/getCategories")
    public Category[] getCategories() {
        return Category.values();
    }
}
