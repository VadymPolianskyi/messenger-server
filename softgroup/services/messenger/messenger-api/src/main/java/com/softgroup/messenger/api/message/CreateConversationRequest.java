package com.softgroup.messenger.api.message;

import com.softgroup.messenger.api.message.data.ChatType;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:13
 */
public class CreateConversationRequest extends MessengerRequest{
    private ChatType type;
    private List<String> membersIDs;

    public List<String> getMembersIDs() {
        return membersIDs;
    }

    public void setMembersIDs(List<String> membersIDs) {
        this.membersIDs = membersIDs;
    }

    public ChatType getType() {

        return type;
    }

    public void setType(ChatType type) {
        this.type = type;
    }
}
