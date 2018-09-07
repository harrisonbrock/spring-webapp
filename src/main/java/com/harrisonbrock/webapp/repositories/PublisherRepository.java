package com.harrisonbrock.webapp.repositories;

import com.harrisonbrock.webapp.models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
