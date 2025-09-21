package com.giuseppefrattura.spring6webapp.services;


import com.giuseppefrattura.spring6webapp.mappers.CustomerMapper;
import com.giuseppefrattura.spring6webapp.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
}
