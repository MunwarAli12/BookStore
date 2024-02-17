package com.example.bookstore.service;

public class IdDup extends RuntimeException {
    public IdDup(String message) {
        super(message);
    }
}