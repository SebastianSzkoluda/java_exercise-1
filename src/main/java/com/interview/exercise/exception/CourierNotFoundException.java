package com.interview.exercise.exception;

public class CourierNotFoundException extends RuntimeException {

    public CourierNotFoundException(String msg) {
        super(msg);
    }
}
