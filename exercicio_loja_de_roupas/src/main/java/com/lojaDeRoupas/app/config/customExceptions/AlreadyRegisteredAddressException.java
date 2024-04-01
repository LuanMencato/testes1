package com.lojaDeRoupas.app.config.customExceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AlreadyRegisteredAddressException extends RuntimeException{
    public AlreadyRegisteredAddressException(String message){
        super(message);
    }
}
