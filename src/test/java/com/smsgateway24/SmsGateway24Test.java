package com.smsgateway24;

import com.smsgateway24.dataobjects.Device;
import com.smsgateway24.exceptions.TokenException;
import com.smsgateway24.token.Token;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SmsGateway24Test {

    @Test
    void testTokenException() {
        SmsGateway24 sms = new SmsGateway24();
        Throwable exception = assertThrows(TokenException.class, () -> sms.getToken("smsgateway24@mailinator.com", "11qn2NAa9AP8qcFHp"));
        assertEquals("Login or password incorrect", exception.getMessage());
    }

    @Test
    void testGetToken() {
        SmsGateway24 sms = new SmsGateway24();
        try {
            String token = sms.getToken("smsgateway24@mailinator.com", "qn2NAa9AP8qcFHp");
            System.out.println(token);
        } catch (TokenException te) {
            te.printStackTrace();
        }
        //{"error":0,"token":"3643122b22cdabf30e832aacd3ce05f3","message":"OK"}
    }

    @Test
    void testAddSms() {
        SmsGateway24 sms = new SmsGateway24(new Token("test"), new Device(2422));
        sms.add("1234567890", "sdfsdfsf");
    }
}