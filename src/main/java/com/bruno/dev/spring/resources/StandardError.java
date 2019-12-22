package com.bruno.dev.spring.resources;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class StandardError implements Serializable {

    private Integer status;
    private String message;
    private Long timeStamp;
}
