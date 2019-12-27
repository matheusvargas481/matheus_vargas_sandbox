package com.matheusvargas481.spring_bootpostgresqldocker.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("Customer not found !");
    }
}
