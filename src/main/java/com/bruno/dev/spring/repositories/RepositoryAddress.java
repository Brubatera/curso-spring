package com.bruno.dev.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.dev.spring.domain.Address;

@Repository
public interface RepositoryAddress extends JpaRepository<Address, Long> {
}
