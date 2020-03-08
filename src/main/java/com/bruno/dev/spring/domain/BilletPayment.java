package com.bruno.dev.spring.domain;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.bruno.dev.spring.domain.enums.PaymentState;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class BilletPayment extends Payment {

	private LocalDate paymentDate;
	private LocalDate dueDate;

	public BilletPayment(Long id, PaymentState paymentState,
			CustomerOrder customerOrder, LocalDate paymentDate, LocalDate dueDate) {
		super( id, paymentState, customerOrder );
		this.paymentDate = paymentDate;
		this.dueDate = dueDate;
	}
}
