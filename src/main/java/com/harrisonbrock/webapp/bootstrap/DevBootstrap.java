package com.harrisonbrock.webapp.bootstrap;

import com.harrisonbrock.webapp.models.Author;
import com.harrisonbrock.webapp.models.Book;
import com.harrisonbrock.webapp.repositories.AuthorRepository;
import com.harrisonbrock.webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123456778", "wrox");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author bob = new Author("Bob", "Green");
        Book javaD = new Book("Java Design", "1548651", "wrox");
        bob.getBooks().add(javaD);
        javaD.getAuthors().add(bob);

        authorRepository.save(eric);
        authorRepository.save(bob);

        bookRepository.save(ddd);
        bookRepository.save(javaD);

    }
}

