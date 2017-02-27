package com.softgroup.messenger.api.message;

import com.softgroup.messenger.api.message.data.Cursor;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:16
 */
public class GetMessagesRequest extends MessengerRequest {

    public GetMessagesRequest() {
        getHeader().setCommand("getMessagesRequest");
    }

    private String conversationID;
    private Cursor cursor;

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }
}
