package com.harrisonbrock.webapp.bootstrap;

import com.harrisonbrock.webapp.models.Author;
import com.harrisonbrock.webapp.models.Book;
import com.harrisonbrock.webapp.models.Publisher;
import com.harrisonbrock.webapp.repositories.AuthorRepository;
import com.harrisonbrock.webapp.repositories.BookRepository;
import com.harrisonbrock.webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher wrox = new Publisher("Worx", "Some street 0007", "58565");
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123456778", wrox);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Publisher apress = new Publisher("Apress", "Some street 70507", "9745415");
        Author bob = new Author("Bob", "Green");
        Book javaD = new Book("Java Design", "1548651", apress);
        bob.getBooks().add(javaD);
        javaD.getAuthors().add(bob);

        publisherRepository.save(wrox);
        authorRepository.save(eric);
        authorRepository.save(bob);

        publisherRepository.save(apress);
        bookRepository.save(ddd);
        bookRepository.save(javaD);

    }
}

