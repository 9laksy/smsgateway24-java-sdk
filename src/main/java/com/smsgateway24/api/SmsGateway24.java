package com.smsgateway24.api;

import com.smsgateway24.exceptions.TokenException;

public interface SmsGateway24 {

    default String getToken(String email, String password) throws TokenException {
        return null;
    }
    default String add(String sendTo, String body) {
        return null;
    }

    default String add(String sendTo, String body, String dateTimeToSend, int sim, String customer_id, boolean urgent) {
        return null;
    }
}
