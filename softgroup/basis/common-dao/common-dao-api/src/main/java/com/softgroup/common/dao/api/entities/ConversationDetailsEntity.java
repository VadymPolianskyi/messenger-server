package com.softgroup.common.dao.api.entities;

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
public class ConversationDetailsEntity implements Serializable {

    private static final long serialVersionUID = -4252569167518812471L;

    @Id
    @Column(name = "id", unique = true)
    private String id;


    @Column(name = "date")
    private Date dateOfCreation;

    @Column(name = "title")
    private String title;

    @OneToOne
    private MessageEntity cursor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MessageEntity getCursor() {
        return cursor;
    }

    public void setCursor(MessageEntity cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConversationDetailsEntity)) return false;

        ConversationDetailsEntity that = (ConversationDetailsEntity) o;

        if (!id.equals(that.id)) return false;
        if (!dateOfCreation.equals(that.dateOfCreation)) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return cursor != null ? cursor.equals(that.cursor) : that.cursor == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + dateOfCreation.hashCode();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (cursor != null ? cursor.hashCode() : 0);
        return result;
    }
}
