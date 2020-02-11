package com.bruno.dev.spring.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.bruno.dev.spring.domain.enums.CustomerType;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Customer implements Serializable {

	private Long id;
	private String name;
	private String email;
	private String cpfOrCnpj;
	private Integer customerType;
	private List<Address> addresses = new ArrayList<>();
	private Set<String> telephones = new HashSet<>();

	public Customer(Long id, String name, String email, String cpfOrCnpj, CustomerType customerType) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOrCnpj = cpfOrCnpj;
		this.customerType = customerType.getCod();
	}

	public CustomerType getCustomerType() {
		return CustomerType.toEnum( customerType );
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType.getCod();
	}
}




