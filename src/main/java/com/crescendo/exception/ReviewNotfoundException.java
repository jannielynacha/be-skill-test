package com.crescendo.exception;

public class ReviewNotfoundException extends RuntimeException {
    public ReviewNotfoundException(int id) {
        super("Review with id " + id + " not found.");
    }
}
