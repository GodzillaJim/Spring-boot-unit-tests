package com.godzillajim.unittestingintegration.controllers;

import com.godzillajim.unittestingintegration.entities.library.Book;
import com.godzillajim.unittestingintegration.entities.library.BookDTO;
import com.godzillajim.unittestingintegration.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookControllerTest {
    @Autowired
    BookController bookController;

    // Mocking some classes
    @MockBean
    BookService bookService;
    // Add Book Test
    @Test
    void addBookTest(){
        // Mocking
        BookDTO book = createBookDTO();
        when(bookService.addBook(new Book(book.getIsbn(),
                book.getAisle(), book.getAuthor(),book.getTitle(),book.getTags())))
                .thenReturn(createBook());
        ResponseEntity<Book> response =
                bookController.addBook(createBookDTO());
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(book.getAuthor(), Objects.requireNonNull(response.getBody()).getAuthor());
    }
    public BookDTO createBookDTO (){

        BookDTO book = new BookDTO();
        book.setAisle("500");
        book.setAuthor("Robert Greene");
        book.setIsbn("795484461818");
        book.setTags("the old lazy fox jumped over the fence");
        return book;
    }
    public Book createBook(){
        BookDTO bookDTO = createBookDTO();
        Book book = new Book();
        book.setIsbn(bookDTO.getIsbn());
        book.setAisle(bookDTO.getAisle());
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());
        book.setTags(bookDTO.getTags());

        book.setCreatedAt(new Date());
        book.setModifiedAt(new Date());
        book.setId(121L);

        return book;
    }
}
