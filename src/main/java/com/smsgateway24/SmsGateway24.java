package com.smsgateway24;

import com.smsgateway24.http.Client;
import com.smsgateway24.token.Token;

public class SmsGateway24 {

    final static String DEFAULT_TIMEOUT = "3.0";
    final static String BASE_URL = "https://smsgateway24.com/getdata/";
    protected Client client;

    public SmsGateway24(Token token) {
        this.client = new Client(token, BASE_URL);
    }


    public static void main(String[] args) {
    }
}
