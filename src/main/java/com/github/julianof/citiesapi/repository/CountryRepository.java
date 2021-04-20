package com.github.julianof.citiesapi.repository;

import com.github.julianof.citiesapi.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
