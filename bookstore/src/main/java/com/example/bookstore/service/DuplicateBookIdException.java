package com.example.bookstore.service;

public class DuplicateBookIdException extends RuntimeException {
    public DuplicateBookIdException(String message) {
        super(message);
    }
}
