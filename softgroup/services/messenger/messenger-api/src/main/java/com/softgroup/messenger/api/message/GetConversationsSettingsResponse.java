package com.softgroup.messenger.api.message;

import com.softgroup.messenger.api.message.data.Conversation;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:12
 */
public class GetConversationsSettingsResponse extends MessengerResponse {
    private List<Conversation> conversationsSettings;

    public List<Conversation> getConversationsSettings() {
        return conversationsSettings;
    }

    public void setConversationsSettings(List<Conversation> conversationsSettings) {
        this.conversationsSettings = conversationsSettings;
    }
}
