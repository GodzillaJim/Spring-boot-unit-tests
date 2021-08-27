package com.godzillajim.unittestingintegration.services;

import com.godzillajim.unittestingintegration.entities.library.Book;
import com.godzillajim.unittestingintegration.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookServiceInt {
    List<Book> getAllBooks();
    Book findByIsbn(Long isbn) throws ResourceNotFoundException;
    List<Book> findByTitle(String title);
    List<Book> findByTags(String tags);
    Book findById(Long id) throws ResourceNotFoundException;
    public Book addBook(Book book) throws ResourceNotFoundException;
    public Book updateBook(Book book) throws ResourceNotFoundException;
    Book deleteBook(Book book) throws ResourceNotFoundException;
    List<Book> saveAll(List<Book> books);
}
