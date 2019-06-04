package com.example.demo;

public class StuffNotFoundException extends RuntimeException {
    public StuffNotFoundException(Integer id) {
        super("Could not find stuff by id = " + id);
    }
}