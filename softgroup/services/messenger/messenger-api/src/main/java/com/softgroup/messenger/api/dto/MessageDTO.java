package com.softgroup.messenger.api.dto;

import com.softgroup.common.dao.api.entities.types.MessageType;

/**
 * Author: vadym_polyanski
 * Date: 16.04.17
 * Time: 17:27
 */
public class MessageDTO {

    private String senderId;

    private String conversationId;

    private String payload;

    private MessageType type;

    private Long createDate;

    private Long serverReceiveDate;

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getServerReceiveDate() {
        return serverReceiveDate;
    }

    public void setServerReceiveDate(Long serverReceiveDate) {
        this.serverReceiveDate = serverReceiveDate;
    }
}
