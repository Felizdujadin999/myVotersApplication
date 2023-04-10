package org.semicolon.africa.votersApplication.exceptions;

public class VoterNotFoundException extends Throwable{
    public VoterNotFoundException(String message){
        super(message);
    }
}
