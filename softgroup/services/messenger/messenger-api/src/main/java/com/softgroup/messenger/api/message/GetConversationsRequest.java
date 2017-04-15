package com.softgroup.messenger.api.message;

import com.softgroup.common.dao.api.entities.types.ConversationType;
import com.softgroup.common.protocol.RequestData;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 12:20
 */
public class GetConversationsRequest implements RequestData {

    private ConversationType type;

    public ConversationType getType() {
        return type;
    }

    public void setType(ConversationType type) {
        this.type = type;
    }
}
