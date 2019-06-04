package com.example.demo.model;

import com.example.demo.enums.BookType;

import javax.persistence.*;

@Entity
@Inheritance
public class Book extends Stuff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private BookType bookType;

    public Book() {
    }

    public Book(BookType bookType) {
        this.bookType = bookType;
    }

    public Book(String name, BookType bookType) {
        super(name);
        this.bookType = bookType;
    }

    public Book(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name=" + getName() +
                ", bookType=" + bookType +
                '}';
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
