package com.softgroup.messenger.api.message;

import com.softgroup.messenger.api.message.data.Conversation;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:14
 */
public class GetConversationByIdsResponse extends MessengerResponse  {
    private List<Conversation> conversations;

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }
}
