package com.softgroup.common.dao.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Author: vadym
 * Date: 27.02.17
 * Time: 21:02
 */
@Entity
@Table(name = "conversation_settings")
public class ConversationSettingsEntity implements Serializable {

    private static final long serialVersionUID = 8416163839319051032L;

    @Id
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "data")
    private String data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConversationSettingsEntity)) return false;

        ConversationSettingsEntity that = (ConversationSettingsEntity) o;

        if (!id.equals(that.id)) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
