package com.webautomation.exceptions;

public class ElementNotFoundException extends RuntimeException{
    public ElementNotFoundException(){
        super("HTML Element Not Found");
    }

}
