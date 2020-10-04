package com.interview.exercise.exception;

public class PackageNotFoundException extends RuntimeException {

    public PackageNotFoundException(String msg) {
        super(msg);
    }
}
