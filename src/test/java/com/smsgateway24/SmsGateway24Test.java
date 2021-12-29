package com.smsgateway24;

import com.smsgateway24.dataobjects.Device;
import com.smsgateway24.token.Token;

class SmsGateway24Test {

    @org.junit.jupiter.api.Test
    void testAddSms() {
        SmsGateway24 sms = new SmsGateway24(new Token("test"), new Device(2422));
        sms.add("1234567890", "sdfsdfsf");
    }
}