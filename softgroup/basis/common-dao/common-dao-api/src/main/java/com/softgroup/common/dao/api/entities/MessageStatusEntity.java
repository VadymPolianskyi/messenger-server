package com.softgroup.common.dao.api.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: vadym_polyanski
 * Date: 30.03.17
 * Time: 16:35
 */
@Entity
@Table(name = "message_status")
public class MessageStatusEntity implements Serializable{

    private static final long serialVersionUID = -8995783426823605222L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String  id;

    @Column(name = "message_id")
    private String messageId;

    @Column(name = "status")
    private String status;

    @Column(name = "profile_id")
    private String profileId;

    @Column(name = "conversation_id")
    private String conversationId;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "conf_date")
    private Long confDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public Long getConfDate() {
        return confDate;
    }

    public void setConfDate(Long confDate) {
        this.confDate = confDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageStatusEntity that = (MessageStatusEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (messageId != null ? !messageId.equals(that.messageId) : that.messageId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (profileId != null ? !profileId.equals(that.profileId) : that.profileId != null) return false;
        if (conversationId != null ? !conversationId.equals(that.conversationId) : that.conversationId != null)
            return false;
        if (senderId != null ? !senderId.equals(that.senderId) : that.senderId != null) return false;
        return confDate != null ? confDate.equals(that.confDate) : that.confDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (messageId != null ? messageId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (profileId != null ? profileId.hashCode() : 0);
        result = 31 * result + (conversationId != null ? conversationId.hashCode() : 0);
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (confDate != null ? confDate.hashCode() : 0);
        return result;
    }
}
