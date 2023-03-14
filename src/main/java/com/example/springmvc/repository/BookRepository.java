package com.example.springmvc.repository;

import com.example.springmvc.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    Book save(Book book);

    Optional<Book> getBookByName(String name);


}
