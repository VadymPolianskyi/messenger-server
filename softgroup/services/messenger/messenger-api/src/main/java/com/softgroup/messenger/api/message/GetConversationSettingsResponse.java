package com.softgroup.messenger.api.message;

import com.softgroup.db.entity.data.Conversation;
/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:09
 */
public class GetConversationSettingsResponse extends MessengerResponse {
    private Conversation conversationSettings;

    public Conversation getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(Conversation conversationSettings) {
        this.conversationSettings = conversationSettings;
    }
}
