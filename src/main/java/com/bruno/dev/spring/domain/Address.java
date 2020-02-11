package com.bruno.dev.spring.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
	private Long id;
	private String street;
	private String number;
	private String complementStreet;
	private String neighborhood;
	private String zipCode;
	private City city;
	private Customer customer;
}
