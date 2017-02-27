package com.softgroup.db.entity.data;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 12:21
 */
public class Conversation {
    private int id;
    private ConversationDetails conversationDetails;
    private ConversationSettings conversationSettings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ConversationDetails getConversationDetails() {
        return conversationDetails;
    }

    public void setConversationDetails(ConversationDetails conversationDetails) {
        this.conversationDetails = conversationDetails;
    }

    public ConversationSettings getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(ConversationSettings conversationSettings) {
        this.conversationSettings = conversationSettings;
    }




}
