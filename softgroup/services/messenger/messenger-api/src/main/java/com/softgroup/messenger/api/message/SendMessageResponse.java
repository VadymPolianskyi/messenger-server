package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.MessageDTO;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:19
 */
public class SendMessageResponse implements ResponseData {
    private MessageDTO message;

    public MessageDTO getMessage() {
        return message;
    }

    public void setMessage(MessageDTO message) {
        this.message = message;
    }
}
