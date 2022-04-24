package com.emt.lab.emt_lab.service;

import com.emt.lab.emt_lab.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country saveCountry(Country country);
    Country getCountryById(Long id);
}
