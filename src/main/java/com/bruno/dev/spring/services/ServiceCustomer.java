package com.bruno.dev.spring.services;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.bruno.dev.spring.domain.Customer;
import com.bruno.dev.spring.exceptions.CustomerNotFoundException;
import com.bruno.dev.spring.repositories.RepositoryCustomer;

@AllArgsConstructor
@Service
public class ServiceCustomer {

	private RepositoryCustomer repo;

	public Customer search(Long id) {
		return repo.findById( id ).orElseThrow( CustomerNotFoundException::new );
	}
}
