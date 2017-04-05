package com.softgroup.common.dao.api.entities;

import com.softgroup.common.dao.api.entities.types.ConversationMemberStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Author: vadym
 * Date: 27.02.17
 * Time: 21:02
 */
@Entity
@Table(name = "conversation_details")
public class ConversationMemberEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -4252569167518812471L;

    @Column(name = "profile_id")
    private String profileId;

    @Column(name = "conversation_id")
    private String conversationId;

    @Column(name = "join_date")
    private Long joinDate;

    //    deleted(0)/not deleted(1)
    @Column(name = "status")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationMemberEntity that = (ConversationMemberEntity) o;

        if (profileId != null ? !profileId.equals(that.profileId) : that.profileId != null) return false;
        if (conversationId != null ? !conversationId.equals(that.conversationId) : that.conversationId != null)
            return false;
        if (joinDate != null ? !joinDate.equals(that.joinDate) : that.joinDate != null) return false;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        int result = profileId != null ? profileId.hashCode() : 0;
        result = 31 * result + (conversationId != null ? conversationId.hashCode() : 0);
        result = 31 * result + (joinDate != null ? joinDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
