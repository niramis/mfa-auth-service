package com.auth.mfa;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

public class MfaAuthService {
    private String defaultKey = "W2VZ47PRCY2Q6LCK";

    private GoogleAuthenticator gAuth = new GoogleAuthenticator();


    public String getDefaultSecret() {
        return defaultKey;
    }

    public String generateSecret() {

        GoogleAuthenticatorKey key = gAuth.createCredentials();
        return key.getKey();
    }

    public boolean checkPassword(String secretKey, int password) {
        return gAuth.authorize(secretKey, password);
    }
}
