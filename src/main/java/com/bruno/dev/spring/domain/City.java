package com.bruno.dev.spring.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonManagedReference
    private State state;
}
