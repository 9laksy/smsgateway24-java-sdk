package com.smsgateway24;

import com.google.gson.Gson;
import com.smsgateway24.dataobjects.Device;
import com.smsgateway24.exceptions.ResponseException;
import com.smsgateway24.exceptions.TokenException;
import com.smsgateway24.http.Client;
import com.smsgateway24.http.EndPoints;
import com.smsgateway24.response.AddSmsResponse;
import com.smsgateway24.token.Token;

import java.util.HashMap;
import java.util.Map;

public class SmsGateway24 implements com.smsgateway24.api.SmsGateway24 {

    protected Client client;
    protected Device device;

    public SmsGateway24() {}

    public SmsGateway24(Token token, Device device) {
        this.client = new Client(token);
        this.device = device;
    }

    @Override
    public String getToken(String email, String password) throws ResponseException {
        return new Token(email, password).getValue();
    }

    @Override
    public int add(String sendTo, String body) throws ResponseException {
        return add(sendTo, body, null, 0, null, false);
    }

    /**
     *
     * @param sendTo
     * @param body
     * @param dateTimeToSend (YYYY-MM-DD HH:MM:SS)
     * @param sim
     * @param customer_id
     * @param urgent
     * @return
     */
    @Override
    public int add(String sendTo, String body, String dateTimeToSend, int sim, String customer_id, boolean urgent) throws ResponseException {

        Map<Object, Object> data = new HashMap<>();
        data.put("sendto", sendTo);
        data.put("body", body);
        data.put("device_id", this.device.getDevice_id());
        data.put("timetosend", dateTimeToSend);
        data.put("sim", sim);
        data.put("customerId", customer_id);
        data.put("urgent", urgent);

        AddSmsResponse response = client.parseResponseOf(client.post(EndPoints.ADD_SMS, data), AddSmsResponse.class);
        return response.getSms_id();
    }


}
