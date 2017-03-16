package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 12:20
 */
public class GetConversationsRequest implements RequestData {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
