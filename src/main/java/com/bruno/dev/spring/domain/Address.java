package com.bruno.dev.spring.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String number;
    private String complementStreet;
    private String neighborhood;
    private String zipCode;
    @ManyToOne
    private City city;
    @ManyToOne
    private Customer customer;
}
