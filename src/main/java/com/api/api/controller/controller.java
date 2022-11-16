package com.api.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class controller {
    @Autowired
    private BookRepo repository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {

        List<Book> books = repository.findAll();

        return books;
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        Book book = null;
        Optional<Book> optionalBook = repository.findById(bookId);
        if(optionalBook.isPresent()){
            book = optionalBook.get();
        }

        return book;
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        repository.save(book);
        return book;
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {

        repository.deleteById(bookId);
    }

    @PutMapping("/books/{bookId}")
    public void editBook(@RequestBody Book book) {
        repository.save(book);
    }
}
