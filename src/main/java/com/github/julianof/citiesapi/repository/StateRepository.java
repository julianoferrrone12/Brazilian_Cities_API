package com.github.julianof.citiesapi.repository;

import com.github.julianof.citiesapi.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
