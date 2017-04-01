package com.softgroup.common.dao.api.entities;

import com.softgroup.common.dao.api.entities.types.ConversationType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 12:21
 */
@Entity
@Table(name = "conversation")
public class ConversationEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6612011557733766424L;

    @Column(name = "type")
    private ConversationType type;

    @Column(name = "last_message_id")
    private String lastMessageId;

    @Column(name = "creation_date")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationEntity that = (ConversationEntity) o;

        if (type != that.type) return false;
        if (lastMessageId != null ? !lastMessageId.equals(that.lastMessageId) : that.lastMessageId != null)
            return false;
        return creationDate != null ? creationDate.equals(that.creationDate) : that.creationDate == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (lastMessageId != null ? lastMessageId.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }
}
