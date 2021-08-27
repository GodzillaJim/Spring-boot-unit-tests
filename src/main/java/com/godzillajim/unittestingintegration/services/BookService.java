package com.godzillajim.unittestingintegration.services;

import com.godzillajim.unittestingintegration.entities.library.Book;
import com.godzillajim.unittestingintegration.exceptions.ResourceAlreadyExists;
import com.godzillajim.unittestingintegration.exceptions.ResourceNotFoundException;
import com.godzillajim.unittestingintegration.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BookService implements BookServiceInt{
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    @Override
    public Book findByIsbn(Long isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(()->new ResourceNotFoundException("This book does not exist : " + isbn));
    }
    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
    @Override
    public List<Book> findByTags(String tags) {
        return bookRepository.findByTags(tags);
    }
    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("This book does not exist: + id"));
    }

    @Transactional
    @Override
    public Book addBook(Book book) throws ResourceNotFoundException {
        List<Book> books = bookRepository.findByTitle(book.getTitle());
        if(!books.isEmpty()){
            throw new ResourceAlreadyExists("This book already exists: "+ book.getTitle());
        }
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) throws ResourceNotFoundException {
        Book book1 = findById(book.getId());
        book1.setAisle(book.getAisle());
        book1.setAuthor(book.getAuthor());
        book1.setIsbn(book.getIsbn());
        book1.setTags(book.getTags());
        book1.setTitle(book.getTitle());
        bookRepository.save(book1);
        return book1;
    }

    @Override
    public Book deleteBook(Book book) throws ResourceNotFoundException {
        bookRepository.delete(book);
        return book;
    }

    @Override
    public List<Book> saveAll(List<Book> books) {
        return bookRepository.saveAll(books);
    }
}
