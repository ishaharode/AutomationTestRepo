package com.webautomation.exceptions;

public class DriverNotFoundException extends RuntimeException{

    public DriverNotFoundException(){
        super("No Driver Found");
    }

}
