package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.MessageDTO;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:22
 */
public class GetMessagesResponse implements ResponseData {
    private int totalUnread;
    private MessageDTO cursor;
    private List<MessageDTO> messageEntities;

    public int getTotalUnread() {
        return totalUnread;
    }

    public void setTotalUnread(int totalUnread) {
        this.totalUnread = totalUnread;
    }

    public MessageDTO getCursor() {
        return cursor;
    }

    public void setCursor(MessageDTO cursor) {
        this.cursor = cursor;
    }

    public List<MessageDTO> getMessageEntities() {
        return messageEntities;
    }

    public void setMessageEntities(List<MessageDTO> messageEntities) {
        this.messageEntities = messageEntities;
    }
}
