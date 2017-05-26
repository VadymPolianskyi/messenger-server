package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:12
 */
public class GetConversationByIdsRequest implements RequestData {

    private static final long serialVersionUID = -911582271182859862L;

    public List<String> getConversationIDs() {
        return conversationIDs;
    }

    public void setConversationIDs(List<String> conversationIDs) {
        this.conversationIDs = conversationIDs;
    }

    private List<String> conversationIDs;
}
