package com.github.julianof.citiesapi.controller;

import com.github.julianof.citiesapi.entity.City;
import com.github.julianof.citiesapi.entity.State;
import com.github.julianof.citiesapi.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityController {
    
    private final CityRepository cityRepository;
    
    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    
    @GetMapping
    public Page<City> getCountries(Pageable page) {
        return cityRepository.findAll(page);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<City> getOne(@PathVariable Long id) {
        Optional<City> state = cityRepository.findById(id);
        return state.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
