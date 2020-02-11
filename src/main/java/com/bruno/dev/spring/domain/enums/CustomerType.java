package com.bruno.dev.spring.domain.enums;

import java.util.Arrays;

import lombok.Getter;

import com.bruno.dev.spring.exceptions.CustomerTypeNotFoundException;

@Getter
public enum CustomerType {
	PHYSICALPERSON( 1, "physical person" ),
	LEGALPERSON( 2, "legal person" );

	private int cod;
	private String description;

	CustomerType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public static CustomerType toEnum(Integer cod) {
		if (cod == null)
			return null;

		return Arrays.stream( CustomerType.values() )
				.filter( customerType -> cod.equals( customerType.getCod() ) )
				.findFirst()
				.orElseThrow( CustomerTypeNotFoundException::new );
	}
}
