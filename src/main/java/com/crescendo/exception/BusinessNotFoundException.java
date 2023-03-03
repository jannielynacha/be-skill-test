package com.crescendo.exception;

public class BusinessNotFoundException extends RuntimeException {
    public BusinessNotFoundException(int id) {
        super("Business with id " + id + " not found.");
    }
}
