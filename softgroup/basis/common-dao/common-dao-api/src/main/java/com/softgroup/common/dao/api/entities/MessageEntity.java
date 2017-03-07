package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:24
 */
@Entity
@Table(name = "message")
public class MessageEntity {

    @Id
    @Column(name = "id", unique = true)
    private String  id;

    @ManyToOne(fetch = FetchType.EAGER)
    private ProfileEntity auhtor;

    @ManyToOne(fetch = FetchType.EAGER)
    private ConversationEntity conversationEntity;

    @Column(name = "local_date")
    private Date localDate;

    @Column(name = "message_body")
    private String messageBody;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProfileEntity getAuhtor() {
        return auhtor;
    }

    public void setAuhtor(ProfileEntity auhtor) {
        this.auhtor = auhtor;
    }

    public ConversationEntity getConversationEntity() {
        return conversationEntity;
    }

    public void setConversationEntity(ConversationEntity conversationEntity) {
        this.conversationEntity = conversationEntity;
    }

    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageEntity)) return false;

        MessageEntity that = (MessageEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!auhtor.equals(that.auhtor)) return false;
        if (!conversationEntity.equals(that.conversationEntity)) return false;
        if (!localDate.equals(that.localDate)) return false;
        return messageBody.equals(that.messageBody);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + auhtor.hashCode();
        result = 31 * result + conversationEntity.hashCode();
        result = 31 * result + localDate.hashCode();
        result = 31 * result + messageBody.hashCode();
        return result;
    }
}
