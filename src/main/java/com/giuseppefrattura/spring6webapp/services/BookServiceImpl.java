package com.giuseppefrattura.spring6webapp.services;

import com.giuseppefrattura.spring6webapp.domain.Book;
import com.giuseppefrattura.spring6webapp.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }


    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
