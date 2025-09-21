package com.giuseppefrattura.spring6webapp.controllers;

import com.giuseppefrattura.spring6webapp.services.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @RequestMapping("/books")
    public String getBooks(Model model){
        log.debug("getBooks called");
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

}
