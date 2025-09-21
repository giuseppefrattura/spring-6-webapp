package com.giuseppefrattura.spring6webapp.services;

import com.giuseppefrattura.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

    Book findById(Long id);
}
