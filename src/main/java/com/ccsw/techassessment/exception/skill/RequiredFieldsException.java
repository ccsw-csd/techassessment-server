package com.ccsw.techassessment.exception.skill;

public class RequiredFieldsException extends RuntimeException{
    public RequiredFieldsException(String message) {
        super(message);
    }
}
