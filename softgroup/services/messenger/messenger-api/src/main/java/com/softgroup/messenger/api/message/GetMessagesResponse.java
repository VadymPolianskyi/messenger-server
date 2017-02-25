package com.softgroup.messenger.api.message;

import com.softgroup.messenger.api.message.data.Conversation;
import com.softgroup.messenger.api.message.data.Cursor;
import com.softgroup.messenger.api.message.data.Message;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:22
 */
public class GetMessagesResponse extends MessengerResponse {
    private int totalUnread;
    private List<Cursor> cursors;
    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getTotalUnread() {
        return totalUnread;
    }

    public void setTotalUnread(int totalUnread) {
        this.totalUnread = totalUnread;
    }

    public List<Cursor> getCursors() {
        return cursors;
    }

    public void setCursors(List<Cursor> cursors) {
        this.cursors = cursors;
    }

    private List<Conversation> conversations;

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }
}
