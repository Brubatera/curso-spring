package com.bruno.dev.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.dev.spring.domain.Customer;

@Repository
public interface RepositoryCustomer extends JpaRepository<Customer, Long> {
}
