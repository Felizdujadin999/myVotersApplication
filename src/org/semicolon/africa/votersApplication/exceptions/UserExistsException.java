package org.semicolon.africa.votersApplication.exceptions;

public class UserExistsException extends Throwable{
    public UserExistsException(String message){
        super(message);
    }
}
