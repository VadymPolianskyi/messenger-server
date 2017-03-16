package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:19
 */
public class SendMessageResponse implements ResponseData {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
