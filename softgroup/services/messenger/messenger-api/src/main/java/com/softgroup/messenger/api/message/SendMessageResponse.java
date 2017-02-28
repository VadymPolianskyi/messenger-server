package com.softgroup.messenger.api.message;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:19
 */
public class SendMessageResponse extends MessengerResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
