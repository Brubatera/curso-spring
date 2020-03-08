package com.bruno.dev.spring.domain;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.bruno.dev.spring.domain.enums.PaymentState;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CreditCardPayment extends Payment {

	private Integer installments;

	public CreditCardPayment(Long id, PaymentState paymentState,
			CustomerOrder customerOrder, Integer installments) {
		super( id, paymentState, customerOrder );
		this.installments = installments;
	}
}
