package com.godzillajim.unittestingintegration.repositories;

import com.godzillajim.unittestingintegration.entities.library.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(Long isbn);
    List<Book> findByTitle(String title);
    List<Book> findByTags(String tags);
}
