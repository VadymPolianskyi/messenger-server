package com.softgroup.messenger.api.message;


import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.protocol.ResponseData;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:13
 */
public class CreateConversationResponse implements ResponseData {
    private ConversationEntity conversationEntity;

    public ConversationEntity getConversationEntity() {
        return conversationEntity;
    }

    public void setConversationEntity(ConversationEntity conversationEntity) {
        this.conversationEntity = conversationEntity;
    }
}
