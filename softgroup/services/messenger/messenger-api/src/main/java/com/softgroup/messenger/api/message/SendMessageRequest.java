package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:19
 */
public class SendMessageRequest implements RequestData {
    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
