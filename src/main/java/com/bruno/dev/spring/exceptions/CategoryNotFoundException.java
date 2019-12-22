package com.bruno.dev.spring.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException() {
        super("Id does not exist!");
    }
}
