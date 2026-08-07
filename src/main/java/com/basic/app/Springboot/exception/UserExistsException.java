package com.basic.app.Springboot.exception;

public class UserExistsException extends Exception{

    public UserExistsException(String message) {
        super(message);
    }
}
