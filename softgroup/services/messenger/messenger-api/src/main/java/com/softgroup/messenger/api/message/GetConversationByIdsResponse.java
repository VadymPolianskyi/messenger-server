package com.softgroup.messenger.api.message;


import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:14
 */
public class GetConversationByIdsResponse implements ResponseData {
    private List<ConversationEntity> conversationEntities;

    public List<ConversationEntity> getConversationEntities() {
        return conversationEntities;
    }

    public void setConversationEntities(List<ConversationEntity> conversationEntities) {
        this.conversationEntities = conversationEntities;
    }
}
