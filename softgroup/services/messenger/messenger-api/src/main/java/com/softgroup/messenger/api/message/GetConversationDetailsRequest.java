package com.softgroup.messenger.api.message;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:05
 */
public class GetConversationDetailsRequest extends MessengerRequest {
    private String conversationID;

    public GetConversationDetailsRequest() {
        getHeader().setCommand("getConversationDetails");
    }

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }
}
