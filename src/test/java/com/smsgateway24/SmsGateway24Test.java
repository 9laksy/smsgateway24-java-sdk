package com.smsgateway24;

import com.smsgateway24.dataobjects.Device;
import com.smsgateway24.exceptions.ResponseException;
import com.smsgateway24.exceptions.TokenException;
import com.smsgateway24.token.Token;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SmsGateway24Test {

    @Test
    void testResponseException() {
        SmsGateway24 sms = new SmsGateway24();
        Throwable exception = assertThrows(ResponseException.class, () -> sms.getToken("<your login email>", "<your login password"));
        assertEquals("Login or password incorrect", exception.getMessage());
    }

    @Test
    void testGetToken() {
        SmsGateway24 sms = new SmsGateway24();
        try {
            String token = sms.getToken("<your login email>", "<your login password");
            System.out.println(token);
        } catch (ResponseException te) {
            te.printStackTrace();
        }
        //{"error":0,"token":"ypur token","message":"OK"}
    }

    @Test
    void testAddSms() {
        SmsGateway24 sms = new SmsGateway24(new Token("<your token>"), new Device(2422));
        try {
            sms.add("1234567890", "sdfsdfsf");
        } catch (ResponseException e) {
            e.printStackTrace();
        }
    }
}