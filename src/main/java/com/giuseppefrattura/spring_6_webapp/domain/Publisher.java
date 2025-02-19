package com.giuseppefrattura.spring_6_webapp.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String publisherName;
    private String address;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books = new HashSet<>();

}
