package com.bruno.dev.spring.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.bruno.dev.spring.domain.enums.PaymentState;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public abstract class Payment implements Serializable {

	@Id
	private Long id;
	private PaymentState paymentState;

	@MapsId
	@OneToOne
	@JoinColumn(name = "order_id")
	private CustomerOrder customerOrder;
}

