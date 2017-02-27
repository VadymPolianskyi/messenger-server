package com.softgroup.messenger.api.message;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:33
 */
public class MessagesReadConfirmationRequest extends MessengerRequest {
    private String conversationID;
    private List<String> messagesIDs;

    public List<String> getMessagesIDs() {
        return messagesIDs;
    }

    public void setMessagesIDs(List<String> messagesIDs) {
        this.messagesIDs = messagesIDs;
    }

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }
}
