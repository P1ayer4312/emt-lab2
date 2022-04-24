package com.emt.lab.emt_lab.service.impl;

import com.emt.lab.emt_lab.model.Country;
import com.emt.lab.emt_lab.repository.CountryRepository;
import com.emt.lab.emt_lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return (List<Country>) countryRepository.findAll();
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country getCountryById(Long id) {
        return countryRepository.findById(id).get();
    }
}
