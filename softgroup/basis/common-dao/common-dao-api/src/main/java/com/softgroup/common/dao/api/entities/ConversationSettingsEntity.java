package com.softgroup.common.dao.api.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "admin_id")
    private String adminId;

    @Column(name = "name")
    private String name;

    @Column(name = "logo")
    private String logo;

    @Column(name = "conversation_id")
    private String conversationId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationSettingsEntity that = (ConversationSettingsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (adminId != null ? !adminId.equals(that.adminId) : that.adminId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;
        return conversationId != null ? conversationId.equals(that.conversationId) : that.conversationId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (adminId != null ? adminId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        result = 31 * result + (conversationId != null ? conversationId.hashCode() : 0);
        return result;
    }
}
