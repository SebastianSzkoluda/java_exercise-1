package com.interview.exercise.exception;

public class AppUserNotFoundException extends RuntimeException {

    public AppUserNotFoundException(String msg) {
        super(msg);
    }
}
