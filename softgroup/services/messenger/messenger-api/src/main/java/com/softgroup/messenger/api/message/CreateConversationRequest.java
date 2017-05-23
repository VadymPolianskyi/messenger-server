package com.softgroup.messenger.api.message;

import com.softgroup.common.dao.api.entities.types.ConversationType;
import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:13
 */
public class CreateConversationRequest implements RequestData {

    private static final long serialVersionUID = 3221684326125153963L;

    private ConversationType type;
    private List<String> membersIDs;

    public List<String> getMembersIDs() {
        return membersIDs;
    }

    public void setMembersIDs(List<String> membersIDs) {
        this.membersIDs = membersIDs;
    }

    public ConversationType getType() {
        return type;
    }

    public void setType(ConversationType type) {
        this.type = type;
    }
}
