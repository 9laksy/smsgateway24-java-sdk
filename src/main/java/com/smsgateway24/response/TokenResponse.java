package com.smsgateway24.response;

public class TokenResponse {

    public String token;
    public int error;
    public String message;

    public TokenResponse(int error, String token, String message) {
        this.token = token;
        this.error = error;
        this.message = message;
    }

}
