package com.example.bookstore.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.bookstore.model.Book;


public interface BookRepository extends MongoRepository<Book, Long> {
	List<Book> findByAuthor(String author);
}
