package com.bruno.dev.spring.repositories;

import com.bruno.dev.spring.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryState extends JpaRepository<State, Long> {
}
