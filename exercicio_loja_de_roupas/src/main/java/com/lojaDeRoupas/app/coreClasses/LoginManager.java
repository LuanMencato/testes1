package com.lojaDeRoupas.app.coreClasses;

import jakarta.transaction.Transactional;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
@Transactional
public class LoginManager {
    private String ipAddress;
    private String accessedLogin;
    private String temporaryToken;
    private Long attemptCounter;
    private final List<ObjectLogin> logins = new ArrayList<>();

    public boolean setIPAddressAndLogin(String ipAddress, String login){
        AtomicBoolean result = new AtomicBoolean();
        this.logins.forEach(l -> {
            if(l.ipAddress.equals(ipAddress) ||
                    l.ipAddress.equals(accessedLogin)){
                result.set(false);
            }
        });
        if(result.get()){
            this.ipAddress = ipAddress;
            this.accessedLogin = login;
            return true;
        }
        return false;
    }
    public void increaseAttempts(String ipAddress){
        this.logins.forEach(l -> {
            if(this.ipAddress.equals(ipAddress)){
                l.attemptCounter++;
            }
        });
    }
    public boolean isTheAccessGranted(String ipAddress, String token){
        for (ObjectLogin l : this.logins) {
            if(!l.accessSuspended &&
                    l.ipAddress.equals(ipAddress) &&
                    l.temporaryToken.equals(token)) {
                return true;
            }
        }

        return false;
    }
    public boolean accessValidation(String ipAddress, String login){
        this.increaseAttempts(ipAddress);

        return true;
    }
    public static class ObjectLogin{
        private String ipAddress;
        private String accessedLogin;
        private String  temporaryToken;
        private Long attemptCounter;
        private boolean accessSuspended;
        private boolean temporaryAccessGranted;
    }
}