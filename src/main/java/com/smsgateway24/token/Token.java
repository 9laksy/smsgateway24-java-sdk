package com.smsgateway24.token;

import com.google.gson.Gson;
import com.smsgateway24.exceptions.ResponseException;
import com.smsgateway24.exceptions.TokenException;
import com.smsgateway24.http.Client;
import com.smsgateway24.http.EndPoints;
import com.smsgateway24.response.TokenResponse;

import java.util.HashMap;
import java.util.Map;

public class Token {
    private String value;

    private String email;
    private String pass;

    public Token(String email, String password) throws ResponseException {
        this.email = email;
        this.pass = password;
        this.getToken();
    }

    public Token(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private void getToken() throws ResponseException {
        Client c = new Client();

        Map<Object, Object> data = new HashMap<>();
        data.put("email", this.email);
        data.put("pass", this.pass);

        Gson gson = new Gson();
        TokenResponse tokenResponse = c.parseResponseOf(c.post(EndPoints.GET_TOKEN, data), TokenResponse.class);
        this.setValue(tokenResponse.token);
    }
}
