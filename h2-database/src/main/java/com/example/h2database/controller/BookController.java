package com.example.h2database.controller;

import com.example.h2database.model.Book;
import com.example.h2database.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public Iterable<Book> findAll(){
        return repository.findAll();
    }
}
