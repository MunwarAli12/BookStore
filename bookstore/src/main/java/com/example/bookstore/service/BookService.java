package com.example.bookstore.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;


@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

   
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book with ID " + id + " not found"); 
        }
        bookRepository.deleteById(id);
    }
    
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IdDup("ID is not present in the database."));
    }

    public Book addBook(Book book) {
    	   if (bookRepository.existsById(book.getId())) {
               throw new DuplicateBookIdException("Book with ID " + book.getId() + " already exists.");
           }
          
        return bookRepository.save(book);
    }

	public Book updateBook(Book book) {
        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPages(book.getPages());
            return bookRepository.save(existingBook);
        } else {
            throw new BookNotFoundException("Book with ID " + book.getId() + " not found");
        }
    }


	 public List<Book> getBooksByAuthor(String author) {
	        List<Book> books = bookRepository.findByAuthor(author);
	        if (books.isEmpty()) {
	            throw new AuthorNotFoundException("Author '" + author + "' not found in the database");
	        }
	        return books;
	    }
}
