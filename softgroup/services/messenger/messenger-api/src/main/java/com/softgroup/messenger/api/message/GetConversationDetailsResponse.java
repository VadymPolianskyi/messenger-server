package com.softgroup.messenger.api.message;

import com.softgroup.messenger.api.message.data.Conversation;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:05
 */
public class GetConversationDetailsResponse extends MessengerResponse {
    private Conversation conversationDetails;

    public Conversation getConversationDetails() {
        return conversationDetails;
    }

    public void setConversationDetails(Conversation conversationDetails) {
        this.conversationDetails = conversationDetails;
    }
}
