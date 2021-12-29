package com.smsgateway24.exceptions;

import com.smsgateway24.response.Response;

public class ResponseException extends Exception {

    public ResponseException(String message) {
        super(message);
    }
}
