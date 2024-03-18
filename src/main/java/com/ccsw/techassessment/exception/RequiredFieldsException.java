package com.ccsw.techassessment.exception;

public class RequiredFieldsException extends RuntimeException{
    public RequiredFieldsException(String message) {
        super(message);
    }
}
