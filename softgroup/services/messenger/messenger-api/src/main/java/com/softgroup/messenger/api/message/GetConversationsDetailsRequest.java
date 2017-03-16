package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:08
 */
public class GetConversationsDetailsRequest implements RequestData {
    public List<String> getConversationIDs() {
        return conversationIDs;
    }

    public void setConversationIDs(List<String> conversationIDs) {
        this.conversationIDs = conversationIDs;
    }

    private List<String> conversationIDs;
}
