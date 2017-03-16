package com.softgroup.messenger.api.message;


import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.protocol.ResponseData;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:09
 */
public class GetConversationSettingsResponse implements ResponseData {
    private ConversationEntity conversationEntitySettings;

    public ConversationEntity getConversationEntitySettings() {
        return conversationEntitySettings;
    }

    public void setConversationEntitySettings(ConversationEntity conversationEntitySettings) {
        this.conversationEntitySettings = conversationEntitySettings;
    }
}
