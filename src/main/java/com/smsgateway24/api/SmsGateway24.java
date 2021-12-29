package com.smsgateway24.api;

import com.smsgateway24.exceptions.ResponseException;
import com.smsgateway24.exceptions.TokenException;

public interface SmsGateway24 {

    default String getToken(String email, String password) throws ResponseException {
        return null;
    }
    int add(String sendTo, String body) throws ResponseException;

    int add(String sendTo, String body, String dateTimeToSend, int sim, String customer_id, boolean urgent) throws ResponseException;
}
