package com.smsgateway24.response;

public class TokenResponse extends Response{

    public String token;

    public TokenResponse(int error, String token, String message) {
        super(error, message);
        this.token = token;
    }

}
