package com.bruno.dev.spring.resources;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.dev.spring.services.ServiceCustomer;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/customers")
public class ResourceCustomer {

	private ServiceCustomer service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> search(@PathVariable Long id) {
		return ResponseEntity.ok().body( service.search( id ) );
	}
}
