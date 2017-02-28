package com.softgroup.messenger.api.message;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:20
 */
public class IsTypingInChatRequest extends MessengerRequest {

    public IsTypingInChatRequest() {
        getHeader().setCommand("getMessagesRequest");
    }

    private String conversationID;

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }
}
