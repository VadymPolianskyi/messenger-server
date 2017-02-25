package com.softgroup.messenger.api.message;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:12
 */
public class GetConversationByIdsRequest extends MessengerRequest {
    public List<String> getConversationIDs() {
        return conversationIDs;
    }

    public GetConversationByIdsRequest() {
        getHeader().setCommand("getConversationByIds");
    }
    public void setConversationIDs(List<String> conversationIDs) {
        this.conversationIDs = conversationIDs;
    }

    private List<String> conversationIDs;
}
