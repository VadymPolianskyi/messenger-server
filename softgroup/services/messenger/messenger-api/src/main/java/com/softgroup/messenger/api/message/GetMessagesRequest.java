package com.softgroup.messenger.api.message;


import com.softgroup.common.protocol.RequestData;
import com.softgroup.messenger.api.dto.MessageDTO;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:16
 */
public class GetMessagesRequest implements RequestData {

    private String conversationID;
    private MessageDTO cursor;

    public MessageDTO getCursor() {
        return cursor;
    }

    public void setCursor(MessageDTO cursor) {
        this.cursor = cursor;
    }

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }
}
