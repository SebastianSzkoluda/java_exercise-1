package com.interview.exercise.exception;

public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException(String msg) {
        super(msg);
    }
}
