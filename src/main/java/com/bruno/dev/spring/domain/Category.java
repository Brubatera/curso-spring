package com.bruno.dev.spring.domain;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
public class Category implements Serializable {

    private Long id;
    private String name;
}
