package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:13
 */
public class CreateConversationRequest implements RequestData {

    private String type;
    private List<String> membersIDs;

    public List<String> getMembersIDs() {
        return membersIDs;
    }

    public void setMembersIDs(List<String> membersIDs) {
        this.membersIDs = membersIDs;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
