package com.softgroup.common.dao.api.entities;

import com.softgroup.common.dao.api.entities.types.MessageType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:24
 */
@Entity
@Table(name = "message")
public class MessageEntity implements Serializable {

    private static final long serialVersionUID = -4749434979191853677L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String  id;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "conversation_id")
    private String conversationId;

    @Column(name = "payload")
    private String payload;

    @Column(name = "type")
    private MessageType type;

    @Column(name = "create_date")
    private Long createDate;

    @Column(name = "server_receive_date")
    private Long serverReceiveDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Long getServerRecDate() {
        return serverReceiveDate;
    }

    public void setServerRecDate(Long serverReceiveDate) {
        this.serverReceiveDate = serverReceiveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (senderId != null ? !senderId.equals(that.senderId) : that.senderId != null) return false;
        if (conversationId != null ? !conversationId.equals(that.conversationId) : that.conversationId != null)
            return false;
        if (payload != null ? !payload.equals(that.payload) : that.payload != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        return serverReceiveDate != null ? serverReceiveDate.equals(that.serverReceiveDate) : that.serverReceiveDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (conversationId != null ? conversationId.hashCode() : 0);
        result = 31 * result + (payload != null ? payload.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (serverReceiveDate != null ? serverReceiveDate.hashCode() : 0);
        return result;
    }
}
