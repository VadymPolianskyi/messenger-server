package com.softgroup.messenger.api.message;


import com.softgroup.common.dao.api.entities.MessageEntity;
import com.softgroup.common.protocol.RequestData;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:16
 */
public class GetMessagesRequest implements RequestData {

    private String conversationID;
    private MessageEntity cursor;

    public MessageEntity getCursor() {
        return cursor;
    }

    public void setCursor(MessageEntity cursor) {
        this.cursor = cursor;
    }

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }
}
