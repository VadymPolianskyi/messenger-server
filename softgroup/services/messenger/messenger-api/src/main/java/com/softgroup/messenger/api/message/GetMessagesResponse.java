package com.softgroup.messenger.api.message;

import com.softgroup.db.entity.data.Conversation;
import com.softgroup.db.entity.data.Message;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:22
 */
public class GetMessagesResponse extends MessengerResponse {
    private int totalUnread;
    private List<Message> cursors;
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

    public List<Message> getCursors() {
        return cursors;
    }

    public void setCursors(List<Message> cursors) {
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
