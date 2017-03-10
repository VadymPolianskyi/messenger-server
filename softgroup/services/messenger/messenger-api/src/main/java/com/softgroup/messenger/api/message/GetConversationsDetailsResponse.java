package com.softgroup.messenger.api.message;


import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:07
 */
public class GetConversationsDetailsResponse implements ResponseData {
    private List<ConversationEntity> conversationsDetails;

    public List<ConversationEntity> getConversationsDetails() {
        return conversationsDetails;
    }

    public void setConversationsDetails(List<ConversationEntity> conversationsDetails) {
        this.conversationsDetails = conversationsDetails;
    }
}
