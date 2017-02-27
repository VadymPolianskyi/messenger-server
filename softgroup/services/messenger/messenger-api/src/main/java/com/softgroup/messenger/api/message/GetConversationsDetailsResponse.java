package com.softgroup.messenger.api.message;

import com.softgroup.messenger.api.message.data.Conversation;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:07
 */
public class GetConversationsDetailsResponse extends MessengerResponse {
    private List<Conversation> conversationsDetails;

    public List<Conversation> getConversationsDetails() {
        return conversationsDetails;
    }

    public void setConversationsDetails(List<Conversation> conversationsDetails) {
        this.conversationsDetails = conversationsDetails;
    }
}
