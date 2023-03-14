package com.example.springmvc.service;

import com.example.springmvc.dto.BookDTO;
import com.example.springmvc.entity.Book;
import com.example.springmvc.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDTO getBookName(String name) {
        Book book = bookRepository.getBookByName(name).orElseGet(() -> Book.test());
        System.out.println(book);
        BookDTO bookDTO = new BookDTO();
        bookDTO.setName(book.getName());
        bookDTO.setLink(book.getLink());
        return bookDTO;
    }

//    public boolean books(String name) {
//        return getBookName(name);
//    }


}
