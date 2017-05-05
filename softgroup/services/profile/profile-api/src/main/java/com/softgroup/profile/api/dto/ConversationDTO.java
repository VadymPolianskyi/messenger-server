package com.softgroup.profile.api.dto;

import com.softgroup.common.dao.api.entities.types.ConversationType;

/**
 * Author: vadym_polyanski
 * Date: 08.04.17
 * Time: 22:27
 */
public class ConversationDTO {

    private ConversationType type;

    private String lastMessageId;

    private Long creationDate;

    public ConversationType getType() {
        return type;
    }

    public void setType(ConversationType type) {
        this.type = type;
    }

    public String getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(String lastMessageId) {
        this.lastMessageId = lastMessageId;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }
}
