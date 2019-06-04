package com.example.demo;

import com.example.demo.model.Book;

import com.example.demo.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class StuffController {
    private BookRepository bookRepository;

    public StuffController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/stuff/")
    public Iterable<Book> all() {
        return bookRepository.findAll();
    }

    @GetMapping("/stuff/{id}")
    Book one(@PathVariable Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new StuffNotFoundException(id));
    }

    @PostMapping("/stuff")
    Book newStuff(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }

    @PutMapping("/stuff/{id}")
    Book replaceStuff(@RequestBody Book newBook,
                           @PathVariable Integer id) {
        return (Book) bookRepository.findById(id)
                .map(stuff -> {
                    stuff.setName(newBook.getName());
                    stuff.setBookType(newBook.getBookType());
                    stuff.setId(id);
                    return bookRepository.save(stuff);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return bookRepository.save(newBook);
                });
    }

    @DeleteMapping("/stuff/{id}")
    public void deleteCosmetics(@PathVariable Integer id) {
        bookRepository.deleteById(id);
    }
}