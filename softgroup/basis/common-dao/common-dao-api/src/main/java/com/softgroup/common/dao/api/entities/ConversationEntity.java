package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 12:21
 */
@Entity
@Table(name = "conversation")
public class ConversationEntity implements Serializable {

    private static final long serialVersionUID = -6612011557733766424L;

    @Id
    @Column(name = "id", unique = true)
    private String id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<MessageEntity> messageEntities;

    @OneToOne(fetch = FetchType.EAGER)
    private ConversationDetailsEntity conversationDetailsEntity;

    @OneToOne(fetch = FetchType.EAGER)
    private ConversationSettingsEntity conversationSettings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MessageEntity> getMessageEntities() {
        return messageEntities;
    }

    public void setMessageEntities(List<MessageEntity> messageEntities) {
        this.messageEntities = messageEntities;
    }

    public ConversationDetailsEntity getConversationDetailsEntity() {
        return conversationDetailsEntity;
    }

    public void setConversationDetailsEntity(ConversationDetailsEntity conversationDetailsEntity) {
        this.conversationDetailsEntity = conversationDetailsEntity;
    }

    public ConversationSettingsEntity getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(ConversationSettingsEntity conversationSettings) {
        this.conversationSettings = conversationSettings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConversationEntity)) return false;

        ConversationEntity that = (ConversationEntity) o;

        if (!id.equals(that.id)) return false;
        if (messageEntities != null ? !messageEntities.equals(that.messageEntities) : that.messageEntities != null)
            return false;
        if (!conversationDetailsEntity.equals(that.conversationDetailsEntity)) return false;
        return conversationSettings.equals(that.conversationSettings);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (messageEntities != null ? messageEntities.hashCode() : 0);
        result = 31 * result + conversationDetailsEntity.hashCode();
        result = 31 * result + conversationSettings.hashCode();
        return result;
    }
}
