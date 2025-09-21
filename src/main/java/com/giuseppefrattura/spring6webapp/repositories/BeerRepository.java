package com.giuseppefrattura.spring6webapp.repositories;

import com.giuseppefrattura.spring6webapp.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
