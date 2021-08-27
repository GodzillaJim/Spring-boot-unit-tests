package com.godzillajim.unittestingintegration.controllers;

import com.godzillajim.unittestingintegration.entities.library.Book;
import com.godzillajim.unittestingintegration.entities.library.BookDTO;
import com.godzillajim.unittestingintegration.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    // Retrieve all books
    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    // Retrieve single book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }
    // Add a book
    @PostMapping("/")
    public ResponseEntity<Book> addBook(@RequestBody BookDTO book){
        return ResponseEntity.ok(bookService.addBook(new Book(book.getIsbn(),
                book.getAisle(), book.getAuthor(),book.getTitle(),book.getTags())));
    }
    // Update Book
    @PutMapping("/")
    public ResponseEntity<Book> updateBook(@RequestBody BookDTO book){
        return ResponseEntity.ok(bookService.updateBook(new Book(book.getIsbn(),
                book.getAisle(), book.getAuthor(),book.getTitle(),book.getTags())));
    }
    // Delete Book
    @DeleteMapping("/")
    public ResponseEntity<Book> deleteBook(@RequestBody BookDTO book){
        return ResponseEntity.ok(bookService.deleteBook(new Book(book.getIsbn(),
                book.getAisle(), book.getAuthor(),book.getTitle(),book.getTags())));
    }
    // Add Many Books
    @PostMapping("/addBooks")
    public ResponseEntity<List<Book>> addManyBooks(@RequestBody List<BookDTO> list){
        List<Book> books = new ArrayList<>();
        list.forEach(book ->
            books.add(new Book(book.getIsbn(),
                    book.getAisle(), book.getAuthor(),book.getTitle(),book.getTags()))
        );
        return ResponseEntity.ok(bookService.saveAll(books));
    }
}
