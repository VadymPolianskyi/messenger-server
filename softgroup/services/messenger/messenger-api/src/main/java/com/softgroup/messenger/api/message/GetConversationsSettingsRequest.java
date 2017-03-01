package com.softgroup.messenger.api.message;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:11
 */
public class GetConversationsSettingsRequest extends MessengerRequest {

    private List<String> conversationsIDs;

    public List<String> getConversationsIDs() {
        return conversationsIDs;
    }

    public void setConversationsIDs(List<String> conversationsIDs) {
        this.conversationsIDs = conversationsIDs;
    }
}
