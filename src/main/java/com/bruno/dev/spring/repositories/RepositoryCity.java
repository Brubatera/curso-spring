package com.bruno.dev.spring.repositories;

import com.bruno.dev.spring.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCity extends JpaRepository<City, Long> {
}
