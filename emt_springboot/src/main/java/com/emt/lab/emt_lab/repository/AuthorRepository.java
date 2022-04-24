package com.emt.lab.emt_lab.repository;

import com.emt.lab.emt_lab.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
