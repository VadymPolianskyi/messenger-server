package com.softgroup.messenger.api.message;


import com.softgroup.db.entity.data.Conversation;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:13
 */
public class CreateConversationResponse extends MessengerResponse {
    private Conversation conversation;

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
