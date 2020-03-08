package com.bruno.dev.spring.domain.enums;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum PaymentState {

	PENDING( 1, "Pending" ),
	PAID( 2, "Paid" ),
	CANCELED( 3, "Canceled" );

	private int cod;
	private String description;

	PaymentState(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public PaymentState toEnum(Integer cod) {
		return Arrays.stream( PaymentState.values() )
				.filter( paymentState -> cod.equals( paymentState.getCod() ) )
				.findFirst()
				.orElseThrow( IllegalArgumentException::new );
	}
}
