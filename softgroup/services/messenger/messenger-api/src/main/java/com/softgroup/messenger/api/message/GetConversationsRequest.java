package com.softgroup.messenger.api.message;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 12:20
 */
public class GetConversationsRequest extends MessengerRequest {

    public GetConversationsRequest() {
        getHeader().setCommand("getConversations");
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
