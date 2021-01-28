package com.github.julianof.citiesapi.controller;

import com.github.julianof.citiesapi.entity.Country;
import com.github.julianof.citiesapi.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {
    
    private final CountryRepository countryRepository;
    
    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    
    @GetMapping
    public Page<Country> getCountries(Pageable page) {
        return countryRepository.findAll(page);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable Long id) {
        Optional<Country> country = countryRepository.findById(id);
        return country.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
