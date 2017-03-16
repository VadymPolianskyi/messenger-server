package com.softgroup.messenger.api.message;


import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:12
 */
public class GetConversationsSettingsResponse implements ResponseData {
    private List<ConversationEntity> conversationsSettings;

    public List<ConversationEntity> getConversationsSettings() {
        return conversationsSettings;
    }

    public void setConversationsSettings(List<ConversationEntity> conversationsSettings) {
        this.conversationsSettings = conversationsSettings;
    }
}
