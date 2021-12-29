package com.smsgateway24.response;

public class AddSms extends Response{
    private int sms_id;

    public AddSms(int error, String message, int sms_id) {
        super(error, message);
        this.sms_id = sms_id;
    }

    public int getSms_id() {
        return sms_id;
    }

    public void setSms_id(int sms_id) {
        this.sms_id = sms_id;
    }
}
