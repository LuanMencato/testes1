package com.lojaDeRoupas.app.config.validations;

import java.util.Set;

public class EnumValidation<T extends Enum<T>>{
    public boolean enumValidation(T param) {
        /*
        Checks if the used Enum has the value of passed by param.
         */
        return param != null && Set.of(param.getDeclaringClass().getEnumConstants()).contains(param);
    }
}
