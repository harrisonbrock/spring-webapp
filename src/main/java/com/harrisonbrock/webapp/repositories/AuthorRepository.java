package com.harrisonbrock.webapp.repositories;

import com.harrisonbrock.webapp.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
