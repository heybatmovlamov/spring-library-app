package com.example.springmvc.controller;

import com.example.springmvc.dto.BookDTO;
import com.example.springmvc.entity.Book;
import com.example.springmvc.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public String getBook() {
        return "book/dist/book";
    }

    @PostMapping(value = "/book")
    public String postBook(@Valid BookDTO bookDTO,Model model, BindingResult bindingResult) {
       BookDTO book =  bookService.getBookName(bookDTO.getName());
        if (book.getName().equals(bookDTO.getName())) {
            model.addAttribute("book",book);
            return "book/dist/book2";
        }
        return "home/dist/home";
    }

//    @RequestMapping(value = "/book2")
//    public String getBookLinkAndName(Model model, BookDTO bookDTO) {
//
//        model.addAttribute("book2", bookDTO);
//        return "book/dist/book2";
//    }
}
