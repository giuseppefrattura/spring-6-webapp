package com.giuseppefrattura.spring_6_webapp.bootstrap;

import com.giuseppefrattura.spring_6_webapp.domain.Author;
import com.giuseppefrattura.spring_6_webapp.domain.Book;
import com.giuseppefrattura.spring_6_webapp.domain.Publisher;
import com.giuseppefrattura.spring_6_webapp.repositories.AuthorRepository;
import com.giuseppefrattura.spring_6_webapp.repositories.BookRepository;
import com.giuseppefrattura.spring_6_webapp.repositories.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setName("Domain Driven Design");
        ddd.setIsbn("sauygds42");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setName("J2EE Development without EJB");
        noEJB.setIsbn("56789");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);


        Publisher publisher = new Publisher();
        publisher.setPublisherName("My publisher");
        publisher.setAddress("15 Gave");
        Publisher publisherSaved = publisherRepository.save(publisher);

        dddSaved.setPublisher(publisherSaved);
        noEJBSaved.setPublisher(publisherSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("Books: " + bookRepository.count());
        System.out.println("Authors: " + authorRepository.count());

    }
}
