package com.smsgateway24.api;

public interface SmsGateway24 {

    default String add(String sendTo, String body) {
        return null;
    }

    default String add(String sendTo, String body, String dateTimeToSend, int sim, String customer_id, boolean urgent) {
        return null;
    }
}
