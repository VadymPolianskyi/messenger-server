package com.softgroup.messenger.api.dto;

import com.softgroup.common.dao.api.entities.types.ConversationMemberStatus;

/**
 * Author: vadym_polyanski
 * Date: 15.04.17
 * Time: 10:17
 */
public class ConversationMemberDTO {
    private String profileId;

    private String conversationId;

    private Long joinDate;

    private ConversationMemberStatus status;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public Long getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Long joinDate) {
        this.joinDate = joinDate;
    }

    public ConversationMemberStatus getStatus() {
        return status;
    }

    public void setStatus(ConversationMemberStatus status) {
        this.status = status;
    }
}
