package com.softgroup.messenger.api.message;


import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.protocol.ResponseData;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:05
 */
public class GetConversationDetailsResponse implements ResponseData {
    private ConversationEntity conversationEntityDetails;

    public ConversationEntity getConversationEntityDetails() {
        return conversationEntityDetails;
    }

    public void setConversationEntityDetails(ConversationEntity conversationEntityDetails) {
        this.conversationEntityDetails = conversationEntityDetails;
    }
}
