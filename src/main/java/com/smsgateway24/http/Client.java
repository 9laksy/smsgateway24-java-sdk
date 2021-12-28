package com.smsgateway24.http;

import com.smsgateway24.token.Token;

public class Client {
    protected Token token;
    protected String baseUrl;

    public Client(Token token, String baseUrl) {
        this.token = token;
        this.baseUrl = baseUrl;
    }

}
