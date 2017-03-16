package com.softgroup.messenger.api.message;


import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.api.entities.MessageEntity;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:22
 */
public class GetMessagesResponse implements ResponseData {
    private int totalUnread;
    private List<MessageEntity> cursors;
    private List<MessageEntity> messageEntities;

    public List<MessageEntity> getMessageEntities() {
        return messageEntities;
    }

    public void setMessageEntities(List<MessageEntity> messageEntities) {
        this.messageEntities = messageEntities;
    }

    public int getTotalUnread() {
        return totalUnread;
    }

    public void setTotalUnread(int totalUnread) {
        this.totalUnread = totalUnread;
    }

    public List<MessageEntity> getCursors() {
        return cursors;
    }

    public void setCursors(List<MessageEntity> cursors) {
        this.cursors = cursors;
    }

    private List<ConversationEntity> conversationEntities;

    public List<ConversationEntity> getConversationEntities() {
        return conversationEntities;
    }

    public void setConversationEntities(List<ConversationEntity> conversationEntities) {
        this.conversationEntities = conversationEntities;
    }
}
