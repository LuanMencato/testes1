package com.lojaDeRoupas.app.config.customExceptions;

public class OldPasswordProvidedException extends RuntimeException {
    public OldPasswordProvidedException(String message){
        super(message);
    }
}
