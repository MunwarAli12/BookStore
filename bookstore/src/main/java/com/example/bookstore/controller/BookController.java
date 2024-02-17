package com.example.bookstore.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.AuthorNotFoundException;
import com.example.bookstore.service.BookNotFoundException;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.DuplicateBookIdException;
import com.example.bookstore.service.IdDup;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.OK).body("Book with ID " + id + " deleted successfully!");
        } catch (BookNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Book with Id " + id + " not found.");
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        try {
            Book book = bookService.getBookById(id);
            return ResponseEntity.ok(book);
        } catch (IdDup e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with ID " + id + " not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving book with ID " + id);
        }
    }

    @GetMapping("/checkBookById/{id}") 
    public ResponseEntity<String> checkBookById(@PathVariable Long id) {
        try {
            Book book = bookService.getBookById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Book with ID " + id + " found.");
        } catch (IdDup e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with ID " + id + " not found.");
        }
    }
    
    @GetMapping("/searchByAuthor/{author}")
    public ResponseEntity<?> getBooksByAuthor(@PathVariable String author) {
        try {
            List<Book> books = bookService.getBooksByAuthor(author);
            return ResponseEntity.ok(books);
        } catch (AuthorNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        try {
            bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body("Hurray! Book saved!");
        } catch (DuplicateBookIdException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book with same ID already exists.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book book) {
        try {
            Book existingBook = bookService.getBookById(id);
            
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPages(book.getPages());
            bookService.updateBook(existingBook);
            
            return ResponseEntity.ok("Book with ID " + id + " updated successfully!");
        } catch (IdDup e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with ID " + id + " not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating book with ID " + id);
        }
    }
}