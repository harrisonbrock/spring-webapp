package com.harrisonbrock.webapp.repositories;

import com.harrisonbrock.webapp.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
