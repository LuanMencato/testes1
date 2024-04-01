package com.lojaDeRoupas.app.coreClasses.userAutentication;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("admin"),
    USER("user"),
    VISITOR("visitor");
    private String role;
}
