package com.softgroup.messenger.api.message;

import com.softgroup.db.entity.data.Message;


/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:16
 */
public class GetMessagesRequest extends MessengerRequest {

    private String conversationID;
    private Message cursor;

    public Message getCursor() {
        return cursor;
    }

    public void setCursor(Message cursor) {
        this.cursor = cursor;
    }

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }
}
