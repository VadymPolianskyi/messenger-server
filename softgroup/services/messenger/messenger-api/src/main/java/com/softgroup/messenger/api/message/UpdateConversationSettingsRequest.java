package com.softgroup.messenger.api.message;

import com.softgroup.messenger.api.message.data.Conversation;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:16
 */
public class UpdateConversationSettingsRequest extends MessengerRequest{

    public UpdateConversationSettingsRequest() {
        getHeader().setCommand("updateConversationSettings");
    }

    private Conversation conversationSettings;

    public Conversation getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(Conversation conversationSettings) {
        this.conversationSettings = conversationSettings;
    }
}
