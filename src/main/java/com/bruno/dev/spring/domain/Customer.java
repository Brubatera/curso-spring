package com.bruno.dev.spring.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.bruno.dev.spring.domain.enums.CustomerType;
import com.sun.xml.bind.v2.schemagen.episode.Package;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String cpfOrCnpj;
	private Integer customerType;

	@OneToMany(mappedBy = "customer")
	private List<Address> addresses = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "TELEPHONE")
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




