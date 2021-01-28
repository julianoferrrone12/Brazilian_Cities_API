package com.github.julianof.citiesapi.controller;

import com.github.julianof.citiesapi.entity.Country;
import com.github.julianof.citiesapi.entity.State;
import com.github.julianof.citiesapi.repository.StateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateController {
    
    private final StateRepository stateRepository;
    
    public StateController(StateRepository countryRepository) {
        this.stateRepository = countryRepository;
    }
    
    @GetMapping
    public Page<State> getCountries(Pageable page) {
        return stateRepository.findAll(page);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<State> getOne(@PathVariable Long id) {
        Optional<State> state = stateRepository.findById(id);
        return state.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
