package com.matheusvargas481.spring_bootpostgresqldocker.exception;

public class ErrorActionCustomerException extends RuntimeException {
    public ErrorActionCustomerException(String message) {
        super(message);
    }
}
