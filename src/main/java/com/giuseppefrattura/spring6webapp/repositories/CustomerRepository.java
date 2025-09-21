package com.giuseppefrattura.spring6webapp.repositories;

import com.giuseppefrattura.spring6webapp.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
