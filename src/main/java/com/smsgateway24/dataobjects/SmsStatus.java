package com.smsgateway24.dataobjects;

public class SmsStatus {
    private int sms_id;
    private int status;
    private String status_description;

    public SmsStatus(int sms_id, int status, String status_description) {
        this.sms_id = sms_id;
        this.status = status;
        this.status_description = status_description;
    }

    public int getSms_id() {
        return sms_id;
    }

    public void setSms_id(int sms_id) {
        this.sms_id = sms_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatus_description() {
        return status_description;
    }

    public void setStatus_description(String status_description) {
        this.status_description = status_description;
    }
}
