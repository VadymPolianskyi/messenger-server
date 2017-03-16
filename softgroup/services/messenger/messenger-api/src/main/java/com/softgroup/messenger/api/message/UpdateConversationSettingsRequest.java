package com.softgroup.messenger.api.message;


import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.protocol.RequestData;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:16
 */
public class UpdateConversationSettingsRequest implements RequestData {

    private ConversationEntity conversationEntitySettings;

    public ConversationEntity getConversationEntitySettings() {
        return conversationEntitySettings;
    }

    public void setConversationEntitySettings(ConversationEntity conversationEntitySettings) {
        this.conversationEntitySettings = conversationEntitySettings;
    }
}
