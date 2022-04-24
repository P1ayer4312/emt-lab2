package com.emt.lab.emt_lab.repository;

import com.emt.lab.emt_lab.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
}
