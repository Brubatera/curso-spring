package com.bruno.dev.spring.exceptions;

public class CustomerTypeNotFoundException extends RuntimeException {

    public CustomerTypeNotFoundException() {
        super("Id for customer type does not exists!");
    }
}
